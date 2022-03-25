# Saikou Extension Template

### to get working on parser instantly
______

## STEPS:

### to compile parser jar

```
gradlew :parsers:build
```

> output in parsers/build/libs/parsers.jar
_____ 

### to compile jars to dex jars for android
add d8 to your path or executable will be present in your 

linux:
>~/Android/Sdk/build-tools/\<version\>/d8

windows:
>%APPDATA%/local/Android/Sdk/build-tools/\<version\>/d8
```
d8 <filename.jar> --output dex/<filename.jar>
```
output dex jar will be present in dex folder