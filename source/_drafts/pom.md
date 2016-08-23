title: Pom.xml
date: 2016-08-23 03:13:06
categories: [后端]
tags: [Maven, Java]
---

```xml
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/maven-v4_0_0.xsd">
	<modelVersion>4.0.0</modelVersion>

	<parent>
		<groupId>com.genscript.gsscm</groupId>
		<artifactId>SCM-top</artifactId>
		<version>2.0.1-SNAPSHOT</version>
	</parent>

	<description>该项目提供美国订单管理等</description>
	<artifactId>SCM-usorder</artifactId>
	<packaging>war</packaging>
	<name>SCM-usorder Maven Webapp</name>
	<url>http://maven.apache.org</url>

	<dependencies>
		<dependency>
			<groupId>com.genscript.gsscm</groupId>
			<artifactId>SCM-common</artifactId>
			<version>${project.version}</version>
			<type>war</type>
		</dependency>
		<dependency>
			<groupId>com.genscript.gsscm</groupId>
			<artifactId>SCM-common</artifactId>
			<version>${project.version}</version>
			<type>jar</type>
			<classifier>classes</classifier>
			<scope>provided</scope>
		</dependency>

		<dependency>
			<groupId>com.genscript.gsscm</groupId>
			<artifactId>SCM-rules</artifactId>
			<version>${project.version}</version>
			<type>war</type>
		</dependency>
		<dependency>
			<groupId>com.genscript.gsscm</groupId>
			<artifactId>SCM-rules</artifactId>
			<version>${project.version}</version>
			<type>jar</type>
			<classifier>classes</classifier>
			<scope>provided</scope>
		</dependency>
	</dependencies>

	<profiles>
		<profile>
			<id>dev</id>
			<properties>
				<profiles.active>dev</profiles.active>
			</properties>
			<activation>
				<activeByDefault>true</activeByDefault>
			</activation>
		</profile>
		<profile>
			<id>test</id>
			<properties>
				<profiles.active>test</profiles.active>
			</properties>

		</profile>
		<profile>
			<id>prod</id>
			<properties>
				<profiles.active>prod</profiles.active>
			</properties>
		</profile>
		<profile>
			<id>drsite</id>
			<properties>
				<profiles.active>drsite</profiles.active>
			</properties>
		</profile>
	</profiles>
	<build>
		<defaultGoal>package</defaultGoal>
		<finalName>SCM-usorder</finalName>
		<plugins>
			<!-- compiler plug-in, set the JDK version and encoding -->
			<plugin>
				<groupId>org.apache.maven.plugins</groupId>
				<artifactId>maven-compiler-plugin</artifactId>
				<version>2.0.2</version>
				<configuration>
					<source>1.6</source>
					<target>1.6</target>
					<encoding>UTF-8</encoding>
				</configuration>
			</plugin>
			<!-- surefire plug-in, set the unit tests, only the implementation of 
				the unit directory, use case to increase the implementation of tests of memory. -->
			<plugin>
				<groupId>org.apache.maven.plugins</groupId>
				<artifactId>maven-surefire-plugin</artifactId>
				<version>2.4.3</version>
				<configuration>
					<argLine>-Xmx256M</argLine>
					<includes>
						<include>**/unit/**/*Test.java</include>
					</includes>
				</configuration>
			</plugin>
			<plugin>
				<groupId>org.apache.maven.plugins</groupId>
				<artifactId>maven-resources-plugin</artifactId>
				<version>2.6</version>
				<configuration>
					<encoding>UTF-8</encoding>
				</configuration>
			</plugin>


			<plugin>
				<groupId>org.apache.maven.plugins</groupId>
				<artifactId>maven-war-plugin</artifactId>
				<version>2.0.2</version>
				<configuration>					<!--<excludes>**/gsscm/inventory/,**/gsscm/manufacture/,**/gsscm/order/,**/gsscm/quote/,**/gsscm/quoteorder/,**/gsscm/purchase/,**/gsscm/product/,**/gsscm/productservice/,**/gsscm/serv/,**/gsscm/report/,**/gsscm/shipment/</excludes>
					-->
				</configuration>
			</plugin>
			<!--
			
			<plugin>
				<artifactId>maven-assembly-plugin</artifactId>
				<version>2.4</version>
				<configuration>
					<archive>
						<addMavenDescriptor>false</addMavenDescriptor>
						<manifest>
							<addDefaultImplementationEntries>true</addDefaultImplementationEntries>
                            <addDefaultSpecificationEntries>true</addDefaultSpecificationEntries>
						</manifest>
					</archive>
					<outputDirectory>target/${project.build.finalName}/WEB-INF/lib</outputDirectory>
				</configuration>
				<executions>
					
					<execution>
						<id>make-common-assembly</id>
						<phase>prepare-package</phase>
						<goals>
							<goal>single</goal>
						</goals>
						<configuration>
							<descriptors>
								<descriptor>src/assembly/common-assembly.xml</descriptor>
							</descriptors>
						</configuration>
					</execution>
					
					<execution>
						<id>make-orderquote-assembly</id>
						<phase>prepare-package</phase>
						<goals>
							<goal>single</goal>
						</goals>
						<configuration>
							<descriptors>
								<descriptor>src/assembly/orderquote-assembly.xml</descriptor>
							</descriptors>
						</configuration>
					</execution>
					<execution>
						<id>make-manufacture-assembly</id>
						<phase>prepare-package</phase>
						<goals>
							<goal>single</goal>
						</goals>
						<configuration>
							<descriptors>
								<descriptor>src/assembly/manufacture-assembly.xml</descriptor>
							</descriptors>
						</configuration>
					</execution>
					<execution>
						<id>make-inventory-assembly</id>
						<phase>prepare-package</phase>
						<goals>
							<goal>single</goal>
						</goals>
						<configuration>
							<descriptors>
								<descriptor>src/assembly/inventory-assembly.xml</descriptor>
							</descriptors>
						</configuration>
					</execution>
					<execution>
						<id>make-shipping-assembly</id>
						<phase>prepare-package</phase>
						<goals>
							<goal>single</goal>
						</goals>
						<configuration>
							<descriptors>
								<descriptor>src/assembly/shipping-assembly.xml</descriptor>
							</descriptors>
						</configuration>
					</execution>
					<execution>
						<id>make-productservice-assembly</id>
						<phase>prepare-package</phase>
						<goals>
							<goal>single</goal>
						</goals>
						<configuration>
							<descriptors>
								<descriptor>src/assembly/productservice-assembly.xml</descriptor>
							</descriptors>
						</configuration>
					</execution>
					<execution>
						<id>make-report-assembly</id>
						<phase>prepare-package</phase>
						<goals>
							<goal>single</goal>
						</goals>
						<configuration>
							<descriptors>
								<descriptor>src/assembly/report-assembly.xml</descriptor>
							</descriptors>
						</configuration>
					</execution>
				</executions>
			</plugin>
			-->



			<plugin>
				<groupId>org.mortbay.jetty</groupId>
				<artifactId>maven-jetty-plugin</artifactId>
			</plugin>

			<plugin>
				<groupId>org.apache.maven.plugins</groupId>
				<artifactId>maven-antrun-plugin</artifactId>
				<version>1.7</version>
				<executions>
					<execution>
						<id>copyproperties</id>
						<phase>process-resources</phase>
						<goals>
							<goal>run</goal>
						</goals>
						<configuration>
							<target>
								<copy file="target/classes/application.${profiles.active}.properties" 
								tofile="target/classes/application.properties" overwrite="true" encoding="utf-8"/>
							</target>
						</configuration>
					</execution>
					<execution>
						<id>makepackage</id>
						<phase>package</phase>
						<goals>
							<goal>run</goal>
						</goals>
						<configuration>
							<target>
								<move file="target/${project.build.finalName}/WEB-INF/classes/schedule/applicationContext-quartz.bean.xml" 
								tofile="target/${project.build.finalName}/WEB-INF/classes/schedule/applicationContext-quartz.xml" />
								<mkdir dir="target/${project.build.finalName}-${profiles.active}/noquantz"/>
								<war destfile="target/${project.build.finalName}-${profiles.active}/noquantz/${project.build.finalName}.war">
									<fileset dir="target/${project.build.finalName}" >
										<!--excludes ="**/gsscm/inventory/**,**/gsscm/manufacture/**,**/gsscm/order/**,**/gsscm/quote/**,**/gsscm/quoteorder/**,**/gsscm/purchase/**,**/gsscm/product/**,**/gsscm/productservice/**,**/gsscm/serv/**,report/**,**/gsscm/shipment/**"-->
									</fileset>
								</war>
								<copy file="target/${project.build.finalName}.war" 
								tofile="target/${project.build.finalName}-${profiles.active}/${project.build.finalName}.war" overwrite="true"/>
							</target>
						</configuration>
					</execution>
				</executions>
			</plugin>
		</plugins>
		<pluginManagement>
			<plugins>
				<plugin>
					<groupId>org.eclipse.m2e</groupId>
					<artifactId>lifecycle-mapping</artifactId>
					<version>1.0.0</version>
					<configuration>
						<lifecycleMappingMetadata>
							<pluginExecutions>
								<pluginExecution>
									<pluginExecutionFilter>
										<groupId>
											org.apache.maven.plugins
										</groupId>
										<artifactId>
											maven-antrun-plugin
										</artifactId>
										<versionRange>
											[1.7,)
										</versionRange>
										<goals>
											<goal>run</goal>
										</goals>
									</pluginExecutionFilter>
									<action>
										<ignore></ignore>
									</action>
								</pluginExecution>
							</pluginExecutions>
						</lifecycleMappingMetadata>
					</configuration>
				</plugin>
			</plugins>
		</pluginManagement>
		<filters>
			<filter>src/main/resources/application.${profiles.active}.properties</filter>
		</filters>
		<resources>
			<resource>
				<directory>src/main/resources</directory>
				<filtering>false</filtering>
			</resource>
			<resource>
				<directory>src/main/resources</directory>
				<filtering>true</filtering>
				<includes>
					<include>**/*.properties</include>
					<include>memcached.xml</include>
				</includes>
			</resource>
		</resources>
	</build>
</project>


```