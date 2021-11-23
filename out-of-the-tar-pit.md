## Out of the tar pit
---
### I. Introduction

- software crisis -> deveplopment and maintenance of large-scale software systems is complexity (state, volume, flow control)

- Take ideas from FP and OOP to apply to large-scale systems

### II. Complexity
- Causes the vast majority of problems with software

- think and reason about systems is crurical importance

- Type of complexity: talking about complexity which makes large systems hard to understand (not algorithm)

### III. Approaches to Understanding
- Two widely used approacehs to understand system

- testing: attempt to understand how system behaves in certain specific situations

- informal reasoning: attempt to understand the system by examining from the inside

- all ways of attempiting to understand a system have their limitations, employ both testing and reasoning

### IV. Causes of Complexity
- Complexity caused by state: 
    
    - presence of state makes programs hard to understand

    - Testing: 
    
        - commont approach: initial state -> assumption that the system would perform the same way

        - number of possible inputs < number of possible states in some cases 

    - Informal Reasoning: 

        - complexity gorwing at exponential rate (affect both testing and reasoning)

        - contaminated: procedure makes use of any other stateful procedure -> able to understand code only from the inside

    - Control

        - ordering

            - progrrammers are forced to over-specify the problem (how the system should work rather than what is desired)

            - aritificial ordering is being imposed, and then further work is done to remove it

            - complicate informal reasoning, person reading does the same work as compiler

        - concurrency

            - different results

    - Code volume

        - secondary effect, but easiest form of complexity measure, interacts badly with other causes

        - as code volume increases, other problem arises


    - Other casues

        - duplicated code, dead code, unnecessary and missed abstraction

        - Three principles 

            - Complexity breeds complexity

            - Simplicity is hard

            - Power corrupts: language-enforced gurantees -> not allow programmers to enter certain stages

### V. Classical approaches to managing complexity

    - OOP

        - Object = some state together + set of procedures for accessing and manipulating (ADT)

        - encapsulation

        - there may be several places where a givne constraint must be enforced

        - strongly biased toward single object constraint 

        - object identity: equivalence relation adds the complexity

        - control: can cause problems

    - FP

        - state:

            - shun state and side effects completely ("pure" form)

            - referential transparency 

        - control:

            - left to right -> same issues

            - use cof control using functionals rather than explicit looping

        - kinds of state

            - implement mutable state by passing functions 

        - State and modularity

            - you can always tell exactly what will control the outcome of a procedure

            - stateful program is completely destroyed, and potentially have to look at every single piece of code in the entire system to determine this information

### VI. Accidents and Essence
    - Essential complexity:
    
        - user

    - Accidental complexity:

        - rest

### Key lessons from Out of the tar pit

- aim for simplicity

- reduce states

