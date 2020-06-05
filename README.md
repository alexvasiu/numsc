![Numsc](logo.png)

# Numsc
This is a library for data science similar to the `numpy` library from **Python**.

## Supported functions
* Arithmetic functions:
    * dot
    * add
    * multiply
    * subtract
    * divide
    * mod
    * \+
    * \-
    * /
    * \*
    * %
* Trigonometric functions:
    * sin
    * cos
    * tan
    * asin
    * acos
    * atan
    * hypot
    * arctan2
    * degrees
    * radians
    * deg2rad
    * rad2deg
    * sinh
    * cosh
    * tanh
* Rounding functions:
    * around
    * floor
    * ceil
    * rint

All these functions are available for **1D** and **2D** arrays and all docs are same as for [Numpy](https://numpy.org/doc/stable/).


## Installing

This package is available for Scala `2.11`, `2.12` and `2.13`. The package could be found [here](https://github.com/alexvasiu/numsc/packages/).

### Sbt

Add to the `build.sbt` file:
```sbt
externalResolvers += "Numsc packages" at "https://maven.pkg.github.com/com.avasiu/numsc"
libraryDependencies += "com.avasiu" %% "numsc" % "0.0.5"
```

### Gradle

Add to the `build.gradle` file:
```groovy
repositories {
    // ...
    maven {url 'https://maven.pkg.github.com/com.avasiu/numsc'}
    // ...
}

dependencies {
    // ...
    implementation "com.avasiu:numsc_2.13:0.0.5" // could also be numsc_2.11 or numsc_2.12
    // ...
}
```

### Maven

Add to the `pom.xml` file:
```xml
<settings>
    <repositories>
        <repository>
         <id>numsc_repo</id>
         <name>Numsc packages</name>
         <url>https://maven.pkg.github.com/com.avasiu/numsc</url>
        </repository>
    </repositories>
    
    <dependencies>
        <dependency>
          <groupId>com.avasiu.numsc_2</groupId>
          <artifactId>13</artifactId> <!-- Could also be 11 or 12 -->
          <version>0.0.5</version>
        </dependency>
    </dependencies>
</settings>
```

## Usage

```scala

import org.avasiu.numsc.ArrayHelpers._

val array: Array[Int] = Array(1, 2, 3)
val newArray = array * 3 // newArray will be Array(3, 6, 9)
```