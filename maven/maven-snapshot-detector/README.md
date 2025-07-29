Simple example for creating maven plugin (source https://vrnsky.medium.com/maven-plugin-development-from-basic-to-advanced-9b666dc55211):
- Take into account naming rules - it should end with "-maven-plugin"
- Take into account maven plugin annotations

To use it run `mvn clean install` in root directory and then add to the test project with snapshot versions and validate with 'mvn validate'

```xml
    <build>
        <plugins>
            <plugin>
                <groupId>com.example</groupId>
                <artifactId>snapshot-detector-maven-plugin</artifactId>
                <version>1.0.0-SNAPSHOT</version>
                <executions>
                    <execution>
                        <goals>
                            <goal>check-snapshots</goal>
                        </goals>
                    </execution>
                </executions>
            </plugin>
        </plugins>
    </build>
```