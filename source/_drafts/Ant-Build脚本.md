title: Ant Build脚本
date: 2016-08-23 03:13:06
categories: [后端]
tags: [Ant, Java]
---

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project name="material" default="war">
	<!-- system environment variables config -->
	<property environment="env" />
	<property file="build.properties" />
	<!-- project config information -->
	<property name="project.home" value="./" />
	<property name="project.name" value="mes.manufacturing" />
	<property name="target.dir" location="${project.home}/target" />
	<property name="classes.dir" location="${target.dir}/classes" />
	<property name="jasper.dir" location="${target.dir}/jasper" />
	<property name="webapp.dir" location="${target.dir}/webapp" />

	<property name="src.main.java" location="${project.home}/src/" />
	<property name="src.main.webapp" location="${project.home}/WebContent/" />
	<property name="library.path" location="${project.home}/WebContent/WEB-INF/lib/" />
	<property name="library.container" location="../../apache-tomcat-8.0.24/lib/" />

	<!-- package config information -->

	<!-- Global classpath config -->
	<path id="master-classpath">
		<!-- Project class files -->
		<pathelement path="${classes.dir}" />
		<!--Project lib files -->
		<fileset dir="${library.path}">
			<include name="**/**" />
		</fileset>
		<!-- Project depend jars -->
		<fileset dir="${library.container}">
			<include name="**/**" />
		</fileset>
	</path>

	<!-- Compile main source tree java files -->
	<target name="compile" description="Compile main source tree java files">
		<delete dir="${project.home}/target"/>
		<mkdir dir="${project.home}/target" />
		<mkdir dir="${classes.dir}" />
		<mkdir dir="${webapp.dir}" />
		<javac destdir="${classes.dir}" target="1.8" includeantruntime="false"
			encoding="UTF-8" deprecation="false" optimize="false" failonerror="true">			
			<src path="${src.main.java}/" />
			<classpath refid="master-classpath" />
		</javac>
		<copy todir="${classes.dir}" preservelastmodified="true">
			<fileset dir="${src.main.java}">
				<include name="**/**/*" />
				<exclude name="**/**/*.java" />
			</fileset>		
		</copy>
	</target>

	<!--
	<target name="jar" depends="compile" description="Build install package">
		<jar jarfile="${target.dir}/${project.name}.jar">
		  <fileset dir="${classes.dir}">
                <include name="com/**/*.*" />
            </fileset>
		</jar>
	</target>
-->

	<!--copy package -->
	<target name="copy" description="copy project into application" depends="compile">

		<!-- class deploy -->
		<copy includeemptydirs="true" todir="${webapp.dir}/WEB-INF/classes">
			<fileset dir="${classes.dir}">
			</fileset>
		</copy>

		<copy includeemptydirs="true" todir="${webapp.dir}">
			<fileset dir="${src.main.webapp}">
				<exclude name="WEB-INF/classes" />
			</fileset>
		</copy>


		<!-- jar deploy -->
		<!--
		<copy todir="${webapp.dir}/WEB-INF/lib">
			<fileset dir="${target.dir}">
				<include name="${project.name}.jar" />
			</fileset>
		</copy>
		-->
	</target>

	<!--package zip -->
	<target name="war" depends="copy" description="war package">
		<delete file="${webapp.dir}/WEB-INF/classes/application.properties"/>
		<copy file="${webapp.dir}/WEB-INF/classes/application.dev.properties"
		     tofile="${webapp.dir}/WEB-INF/classes/application.properties"/>
		<zip zipfile="${target.dir}/${project.name}.war-dev" basedir="${webapp.dir}"></zip>		
	</target>
</project>

```