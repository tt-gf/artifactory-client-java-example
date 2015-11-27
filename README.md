# artifactory-client-java example

This is a sample project using
[artifactory-client-java](https://github.com/JFrogDev/artifactory-client-java) listing all artifacts
in your [Artifactory](https://www.jfrog.com/open-source/).

## Build

```
$ ./gradlew build
```

## Run

```
$ ./gradlew -q execute
Artifactory URL [http://artifactory-ci.tomtomgroup.com/artifactory]: 
User name [root]: 
Password []: 
[...]
com.tomtom/MyGreatPackage/myGreatArtifact.zip
com.tomtom/MyGreaterPackage/myGreaterArtifact.zip
[...]
```

## Troubleshooting

Re-enable the Artifactory client's debug logs in [Example.java](src/main/java/Example.java).

## Variants

[Here](https://gist.github.com/AurelienLourot/033a3c20942308580583) a variant deleting all artifacts
of a repo based on criteria.
