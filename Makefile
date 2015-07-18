SCALA_VER = 2.11
SCALATEST_VER = 2.2.4

all:

deps:	libs/scalatest_${SCALA_VER}-${SCALATEST_VER}.jar

libs/scalatest_${SCALA_VER}-${SCALATEST_VER}.jar:
	mkdir -pv libs
	cd libs && wget https://oss.sonatype.org/content/groups/public/org/scalatest/scalatest_${SCALA_VER}/${SCALATEST_VER}/scalatest_${SCALA_VER}-${SCALATEST_VER}.jar
