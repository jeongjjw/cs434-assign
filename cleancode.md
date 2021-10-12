Chapter 4. Comments
=======
- Comments compensate for our failure to expresss ourself in code 
- Think it through to express in code instead of comments
- Truth can only be found in one place: the code
<br>
### 1.  Comments do not make up for bad code 
    - clear and expressive code with few comments is far superior

### 2. Explain Yourself in Code
    - explain most of your intent in code

### 3. Good Comments
    - Legal

    - informative, explanation of intent, clarification

    - warning of consequences

    - TODO

    - Amplification of importance

### 4. Bad Comments
    - Mumbling: comment has failed to communicate to you

    - Redundant comment: useless
    
    - Misleading comment:  misinformation causes to spend more time 
    
    - Mandated comment: javadoc is not necessary for all functions
    
    - Journal comment, attirbutions and bylines: use source code version system
    
    - Noise comment: avoid comments that causes reader to skip
    
    - Scary noise
    
    - Don't use comment when you can use a function or a variable

    - Position markers: Can be a noise comment

    - Closing brace comment

    - **Commented-out code 

    - HTML comments

    - Nonlocal information, Inbovious connections: make sure that comments and code are near   
    each other, make sure the code and comments is "obviously" connected

    - Too much information

    - Function headers: Use naming instead



Chapter 7. Error Handling
=====
### 1. Use exceptions rather than return codes
### 2. Write your try-catch-finally statement first 
### 3. Provide Context with Exceptions
    - new Error ("error message");
### 4. Define Exception Classes 
    try {
    port.open();
    } catch (DeviceResponseException e) {
    reportPortError(e);
    logger.log("Device response exception", e);
    } catch (ATM1212UnlockedException e) {
    reportPortError(e);
    logger.log("Unlock exception", e);
    } catch (GMXError e) {
    reportPortError(e);
    logger.log("Device response exception");
    } finally {
    …
    }
### 5. Define the normal flow
### 6. NULL


Chapter 8. Boundaries
=======
### 1. Use third-party code 
    - Keep it INSIDE class
### 2. Learning tests
    - log4j 
### 3. Clean boundaries 


Chapter 9. Unit Tests
======
1. The three laws of TDD
- failing unit test -> production code
- don't write unit test than is sufficient to fail
- don't write production code than is sufficent to pass

2. Clean Tests
- keep test clean and readable
- Apply one assert per test
- Single concept per test

3. Five rules
- Fast
- Independent
- Repeatable
- Self-validating
- Timely

- Makes it easier for other people to understand
- preserve and enhance reusability

Chapter 10. Classes
========
1. Classes should be small

2. The Single responsibility principle

3. Maintaining cohesiion results in many small classes

- Classes should be small and easy to read / have single reponsibility for easier maintenanace
