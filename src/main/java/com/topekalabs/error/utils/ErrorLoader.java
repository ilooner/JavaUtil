/*
 * Copyright 2014 Topeka Labs.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.topekalabs.error.utils;

import com.topekalabs.collection.utils.CollectionUtils;
import com.topekalabs.collection.utils.MapUtils;
import com.topekalabs.collection.utils.ReflectionUtils;
import com.topekalabs.collection.utils.SetUtils;
import com.topekalabs.java.utils.ObjectUtils;
import com.topekalabs.string.utils.RegexUtils;
import java.io.IOException;
import java.net.URL;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;
import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import org.reflections.Reflections;
import org.reflections.scanners.ResourcesScanner;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author Topeka Labs
 */
public final class ErrorLoader
{
    private static final Logger logger = LoggerFactory.getLogger(ErrorLoader.class.getName());
    
    public static final String ERROR_SCHEMA_DEFINITION_REGEX = "error_properties\\.xsd";
    public static final Pattern ERROR_SCHEMA_DEFINITION_PATTERN = Pattern.compile(ERROR_SCHEMA_DEFINITION_REGEX);
    public static final String ERROR_PROPERTIES_REGEX = "(.+[\\\\/])*([^\\\\/]+)_error_properties\\.xml";
    public static final Pattern ERROR_PROPERTIES_PATTERN = Pattern.compile(ERROR_PROPERTIES_REGEX);
    public static final int ERROR_PROPERTIES_NAMESPACE_GROUP = 2;
    
    public static final String ERROR_PROPERTIES_JAVAUTIL_REGEX = "javautil_error_properties.xml";
    public static final Pattern ERROR_PROPERTIES_JAVAUTIL_PATTERN = Pattern.compile(ERROR_PROPERTIES_JAVAUTIL_REGEX);
    
    ////////////////////////////////////////////////////////////////////////////
    // Start - XML Tags
    ////////////////////////////////////////////////////////////////////////////
    
    public static final String TAG_ERROR = "error";
    public static final String ATTRIBUTE_ALIAS = "alias";
    public static final String ATTRIBUTE_MESSAGE = "message";
    public static final String ATTRIBUTE_ERRORCODE = "errorCode";
    
    ////////////////////////////////////////////////////////////////////////////
    // End - XML Tags
    ////////////////////////////////////////////////////////////////////////////
            
    private static Map<String, Map<String, ErrorCode>> ALIAS_TO_ERROR_CODE = MapUtils.newNNHashMap();
    private static Map<String, Map<ErrorCode, String>> ERROR_CODE_TO_ALIAS = MapUtils.newNNHashMap();
    private static Map<String, Map<ErrorCode, String>> ERROR_CODE_TO_MESSAGE = MapUtils.newNNHashMap();
    private static Map<String, Set<ErrorCode>> ERROR_CODE_SET = MapUtils.newNNHashMap();
    private static Set<String> NAME_SPACE_SET = SetUtils.newNNHashSet();
    
    static
    {
        Reflections reflections = createReflections();
        
        Schema schema = loadErrorSchema(reflections);
        Set<String> errorPropertiesResources = getErrorProperties(reflections);
        
        String javautilsResource = null;
        
        logger.debug("Number of error resources: {}", errorPropertiesResources.size());
        
        for(String errorPropertiesResource: errorPropertiesResources)
        {
            logger.debug("error properties resource: {}", errorPropertiesResource);
            if(errorPropertiesResource.endsWith(ERROR_PROPERTIES_JAVAUTIL_REGEX))
            {
                javautilsResource = errorPropertiesResource;
            }
        }
        
        if(javautilsResource == null)
        {
            ExceptionUtils.ERROR_THROWER.throwUnrecoverableError("ERROR_LOADING_JAVAUTIL");
        }
        else
        {
            logger.debug("The javautil resource: {}", javautilsResource);
        }
        
        errorPropertiesResources.remove(javautilsResource);
        
        loadErrorProperties(javautilsResource,
                            schema,
                            true);
        
        loadErrorProperties(errorPropertiesResources,
                            schema);
    }
    
    private ErrorLoader()
    {
        //Do nothing
    }
    
    public static String getErrorMessage(String namespace,
                                         String alias)
    {
        ErrorCode errorCode = getErrorCode(namespace,
                                           alias);
        
        return getErrorMessage(namespace,
                               errorCode);
    }
    
    public static String getErrorMessage(String namespace,
                                         ErrorCode errorCode)
    {
        checkErrorCode(namespace,
                       errorCode);
        
        return ERROR_CODE_TO_MESSAGE.get(namespace).get(errorCode);
    }
    
    public static ErrorCode getErrorCode(String namespace,
                                         String alias)
    {
        checkNamespace(namespace);
        ErrorCode errorCode = ALIAS_TO_ERROR_CODE.get(namespace).get(alias);
        
        if(ObjectUtils.isNull(errorCode))
        {
            ExceptionUtils.ERROR_THROWER.throwUnrecoverableError("NO_ERROR_ALIAS");
        }
        
        checkErrorCode(namespace,
                       errorCode);
        
        return errorCode;
    }
    
    public static String getAlias(String namespace,
                                  ErrorCode errorCode)
    {
        checkErrorCode(namespace,
                       errorCode);
        
        return ERROR_CODE_TO_ALIAS.get(namespace).get(errorCode);
    }
    
    protected static void checkErrorCode(String namespace,
                                         ErrorCode errorCode)
    {
        checkNamespace(namespace);
        
        if(!ERROR_CODE_SET.get(namespace).contains(errorCode))
        {
            ExceptionUtils.ERROR_THROWER.throwUnrecoverableError("NO_ERROR_ERROR_CODE");
        }
    }
    
    protected static void checkNamespace(String namespace)
    {
        if(!NAME_SPACE_SET.contains(namespace))
        {
            logger.error("{} not valid namespace.", namespace);
            ExceptionUtils.ERROR_THROWER.throwUnrecoverableError("NO_ERROR_NAMESPACE");
        }
    }
    
    protected static Reflections createReflections(ClassLoader... classLoaders)
    {
        Collection<URL> scanUrls = ClasspathHelper.forClassLoader(ClasspathHelper.classLoaders(classLoaders));
        scanUrls.addAll(ClasspathHelper.forJavaClassPath());
        
        return new Reflections(new ConfigurationBuilder().
                               setUrls(scanUrls).
                               setScanners(new ResourcesScanner()));
    }
    
    protected static Schema loadErrorSchema(Reflections reflections)
    {
        Set<String> schemaResources = reflections.getResources(ERROR_SCHEMA_DEFINITION_PATTERN);
        
        String schemaResource = CollectionUtils.getElementFromSize1(schemaResources);
        URL schemaResourceURL = ReflectionUtils.getResourceURL(schemaResource);
        
        SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        Schema schema = null;
        
        try
        {
            schema = schemaFactory.newSchema(schemaResourceURL);
        }
        catch(SAXException ex)
        {
            ex.printStackTrace();
            ExceptionUtils.rethrow(ex);
        }
        
        return schema;
    }
    
    protected static Set<String> getErrorProperties(Reflections reflections)
    {
        return reflections.getResources(ERROR_PROPERTIES_PATTERN);
    }
    
    protected static void loadErrorProperties(Set<String> errorPropertiesResources,
                                              Schema schema)
    {
        for(String errorPropertiesResource: errorPropertiesResources)
        {
            loadErrorProperties(errorPropertiesResource, schema, false);
        }
    }
    
    protected static void loadErrorProperties(String errorPropertiesResource,
                                              Schema schema,
                                              boolean isJavautils)
    {
        logger.debug("Loading error properties resource at {}.", errorPropertiesResource);
        
        String namespace = RegexUtils.getGroup(ERROR_PROPERTIES_PATTERN,
                                               ERROR_PROPERTIES_NAMESPACE_GROUP,
                                               errorPropertiesResource);
        
        logger.debug("Error resource namespace: {}", namespace);
        
        if(!NAME_SPACE_SET.contains(namespace))
        {
            NAME_SPACE_SET.add(namespace);
        }
        else
        {
            ExceptionUtils.thisShouldNotHappen();
        }
        
        Map<String, ErrorCode> aliasToErrorCode = ALIAS_TO_ERROR_CODE.get(namespace);
        
        if(ObjectUtils.isNull(aliasToErrorCode))
        {
            aliasToErrorCode = MapUtils.newNNHashMap();
            ALIAS_TO_ERROR_CODE.put(namespace, aliasToErrorCode);
        }
        else
        {
            ExceptionUtils.thisShouldNotHappen();
        }
        
        Map<ErrorCode, String> errorCodeToAlias = ERROR_CODE_TO_ALIAS.get(namespace);
        
        if(ObjectUtils.isNull(errorCodeToAlias))
        {
            errorCodeToAlias = MapUtils.newNNHashMap();
            ERROR_CODE_TO_ALIAS.put(namespace, errorCodeToAlias);
        }
        else
        {
            ExceptionUtils.thisShouldNotHappen();
        }
        
        Map<ErrorCode, String> errorCodeToMessage = ERROR_CODE_TO_MESSAGE.get(namespace);
        
        if(ObjectUtils.isNull(errorCodeToMessage))
        {
            errorCodeToMessage = MapUtils.newNNHashMap();
            ERROR_CODE_TO_MESSAGE.put(namespace, errorCodeToMessage);
        }
        else
        {
            ExceptionUtils.thisShouldNotHappen();
        }
        
        Set<ErrorCode> errorCodeSet = ERROR_CODE_SET.get(namespace);
        
        if(ObjectUtils.isNull(errorCodeSet))
        {
            errorCodeSet = SetUtils.newNNHashSet();
            ERROR_CODE_SET.put(namespace, errorCodeSet);
        }
        else
        {
            ExceptionUtils.thisShouldNotHappen();
        }
        
        ////////////////////////////////////////////////////////////////////////
        
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        dbf.setNamespaceAware(true);
        dbf.setValidating(false);
        dbf.setSchema(schema);
        
        Document doc = null;
        
        try
        {
            DocumentBuilder db = dbf.newDocumentBuilder();
            doc = db.parse(ReflectionUtils.getResourceInputStream(errorPropertiesResource));
        }
        catch(ParserConfigurationException | SAXException | IOException ex)
        {
            if(isJavautils)
            {
                ExceptionUtils.thisShouldNotHappen(ex);
            }
            else
            {
                ExceptionUtils.ERROR_THROWER.throwUnrecoverableError("ERROR_LOADING_ERROR_PROPERTIES");
            }
        }
        
        NodeList errorTags = doc.getElementsByTagName(TAG_ERROR);
        
        for(int index = 0;
            index < errorTags.getLength();
            index++)
        {
            Node errorTag = errorTags.item(index);
            NamedNodeMap errorAttributes = errorTag.getAttributes();
            
            Node aliasNode = errorAttributes.getNamedItem(ATTRIBUTE_ALIAS);
            String alias = null;
                    
            if(!ObjectUtils.isNull(aliasNode))
            {
                alias = aliasNode.getNodeValue();
            }
            
            String message = errorAttributes.getNamedItem(ATTRIBUTE_MESSAGE).getNodeValue();
            ErrorCode errorCode = new ErrorCode(Integer.parseInt(errorAttributes.getNamedItem(ATTRIBUTE_ERRORCODE).getNodeValue()));
            
            if(!ObjectUtils.isNull(alias))
            {
                aliasToErrorCode.put(alias, errorCode);
                errorCodeToAlias.put(errorCode, alias);
            }
            
            errorCodeToMessage.put(errorCode, message);
            errorCodeSet.add(errorCode);
        }
    }
}
