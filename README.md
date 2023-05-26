# NotesApp
# It is an Android Kotlin based application which is being designed for creating, saving and deleting notes in your mentioned Notes application database. This application is developed on following Implementations/Usages :
- MVVM(Model–view–viewmodel) 
Architecture Implementation.

-> UI Controller(Activity/Fragment)

-> ViewModelProvider via AndroidViewModelFactory for ViewModel(Holds all Livedata needed for UI , LifeCycle aware & follows a separation of concern of data fetching wrt activity).

-> Repository(Single source of truth for all app data means all data whether accessing from online sources or offline sources ).

-> RoomDatabase(Entity, SQLite, DAO)

-> Room is an ORM, Object Relational Mapping library. In other words, Room will map our database objects to Java objects.

-> Data Access Object

-> Entity(Room allows you to create tables via an entity) which are being accessed through DAO.

- LiveData(UI components observe LiveData and LiveData observes LifeCycle owners means activity/fragment).
 
- Architecture(Room, WorkManager, Lifecycle, DataBinding, Paging, Navigation).

- RoomDb(Room Database) usages in which Room provides an abstraction layer over SQLite to allow fluent database access.

- (Companion Object)Singleton Pattern for creating a single instance of roomDatabase.

- Implementations of inferfaces for item click handing in recyclerview adapter.

- Reference via Google CodeLab.

- Kotlin-kapt plugin for generate kotlin sources.

- Usages of Room Components.

- Usages of Lifecycle Components.

- Usages UI and Testing.

- Coroutines in viewModelScope usages for intializing tasks on background thread rather than on main thread.

- Implementation of RecyclerView , RecyclerViewAdapter and ViewHolder. 

- Usage of Vector Assesst for icons import for Layout/Drawable processing in xmls.


