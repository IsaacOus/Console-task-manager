# ADR-001: Hexagonal Architecture
## Status
Accepted

## Context
Our team has started a new project to develop a task management application using Java. We need to decide on the architecture for the application.

## Decision
We have decided to use Hexagonal Architecture for our application. This architecture provides a clear separation between the domain logic and the infrastructure, making the application more flexible and easier to maintain.

The core idea of this architecture is to define a set of ports and adapters that interact with each other. The ports are the entry and exit points of the application, and the adapters are the implementation of the ports that interact with the infrastructure. This allows us to switch out the adapters without affecting the core domain logic.

We will organize our code into three main layers: the domain layer, the application layer, and the infrastructure layer. The domain layer contains the core business logic and is independent of any infrastructure concerns. The application layer acts as an intermediary between the domain and infrastructure layers, handling the business logic and calling the appropriate adapters. The infrastructure layer contains the implementation of the adapters, such as database, API, and UI.

We will use the builder pattern to create complex objects in the domain layer. This will help us create objects with a lot of optional parameters without the need for multiple constructors.

We will use JUnit 5 for unit testing, which will help us ensure the quality and reliability of our code.

## Consequences
The Hexagonal Architecture will make our application more modular and flexible, allowing us to easily swap out adapters without affecting the core business logic. The builder pattern will make it easier to create complex objects in the domain layer. Using JUnit 5 for testing will help us ensure the quality of our code.

However, this architecture can add some complexity to the codebase, and we will need to ensure that the layers are properly separated. We will need to spend some time on the initial setup to create the necessary interfaces and adapters, but this investment will pay off in the long run.

Overall, we believe that the Hexagonal Architecture will be the best choice for our project, given our requirements and constraints.
