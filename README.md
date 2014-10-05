JavaUtil
========

This project contains common utilities needed for writing java programs like checking int ranges and handling exceptions.
Currently this library is still under active development so only snapshots are available at this time. To include this
library in your project add the following to your pom.xml

        <repository>
          <snapshots />
          <id>snapshots</id>
          <name>libs-snapshot</name>
          <url>https://www.timwiki.com:8443/artifactory/libs-snapshot</url>
        </repository>
        
        <dependency>
            <groupId>com.topekalabs</groupId>
            <artifactId>utils</artifactId>
            <version>1.0-SNAPSHOT</version>
        </dependency>

