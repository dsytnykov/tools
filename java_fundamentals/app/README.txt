my-java-app/
├── src/
│   ├── app/
│   │   └── Main.java
│   └── utils/
│       └── MessageService.java
│
├── resources/
│   └── message.txt
│
└── out/

------------------------------------------------------------------
Classpath
│
├── out
│   ├── app/Main.class
│   └── utils/MessageService.class
│
└── resources
    └── message.txt
# Compile
javac -cp "lib\greeting-lib.jar" -d out src/app/Main.java src/utils/MessageService.java

# Start app
java -cp "out;resources" app.Main

-----------------------------------------------------
# with jar Library
# Compile library
javac -d greeting-lib\out greeting-lib\src\com\example\greeting\Greeter.java

# Package library
jar --create --file lib\greeting-lib.jar -C greeting-lib\out .

# Inspect JAR
jar --list --file lib\greeting-lib.jar
jar tf lib\greeting-lib.jar

# Compile application
javac -cp "lib\greeting-lib.jar" -d out src\app\Main.java src\utils\MessageService.java

# Run application
java -cp "out;resources;lib\greeting-lib.jar" app.Main

Greeter.java
     │
     │ javac
     ↓
Greeter.class
     │
     │ jar
     ↓
greeting-lib.jar
     │
     │ -cp
     ↓
     JVM
     ↑
     │
Main.class