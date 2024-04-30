<h1 align="center"> Animatrix </h1>

<p align="center">  
Animatrix demonstrates modern Android development with Hilt, Coroutines, Flow, Jetpack Compose, ViewModels, and Material Design based on MVI architecture.
</p>

<img src="https://github.com/amanverma-765/Animatrix/assets/46085882/6b6034ad-35e5-4e31-a652-4542509f6619" align="right" width="320"/>

## Tech stack & Open-source libraries
- Minimum SDK level 24.
- [Kotlin](https://kotlinlang.org/) based, utilizing [Coroutines](https://github.com/Kotlin/kotlinx.coroutines) + [Flow](https://kotlin.github.io/kotlinx.coroutines/kotlinx-coroutines-core/kotlinx.coroutines.flow/) for asynchronous operations.
- Jetpack Libraries:
  - Jetpack Compose: Android’s modern toolkit for declarative UI development.
  - Lifecycle: Observes Android lifecycles and manages UI states upon lifecycle changes.
  - ViewModel: Manages UI-related data and is lifecycle-aware, ensuring data survival through configuration changes.
  - [Hilt](https://dagger.dev/hilt/): Facilitates dependency injection.
- Architecture:
  - MVI Architecture (Model - View - Intent): Facilitates separation of concerns and promotes maintainability.
  - Repository Pattern: Acts as a mediator between different data sources and the application's business logic.
- [Ktor](https://github.com/ktorio/ktor): Constructs REST APIs and facilitates paging network data retrieval.
- [Kotlinx-Serialisation]([https://github.com/square/moshi/](https://github.com/Kotlin/kotlinx.serialization)): A modern JSON parsing library.
- [Coil-Compose](https://github.com/coil-kt/coil): A highly optimized Jetpack Compose and Kotlin Multiplatform image loading library that fetches and displays network images.


<br>
<br>

## Architecture
**Animatrix** adheres to the Clean MVI architecture and implements the Repository pattern.

<img src="https://github.com/amanverma-765/Animatrix/assets/46085882/dfb86d7f-1983-45cb-950a-126bbe9258ce" align="center" width="1000"/>

- Each layer adheres to the principles of [unidirectional event/data flow](https://developer.android.com/topic/architecture/ui-layer#udf): the UI layer sends user events to the data layer, and the data layer provides data streams to other layers.
- The data layer operates autonomously from other layers, maintaining purity without dependencies on external layers.

- This loosely coupled architecture enhances component reusability and app scalability, facilitating seamless development and maintenance.

## Rest Api
Animatrix is using the [Neko](https://docs.nekos.best/) for constructing RESTful API


