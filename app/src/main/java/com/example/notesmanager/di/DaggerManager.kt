package com.example.notesmanager.di

import android.content.Context
import com.example.notesmanager.business.mapper.IMapper
import com.example.notesmanager.business.mapper.NotesDatabaseMapper
import com.example.notesmanager.database.INoteListRepository
import com.example.notesmanager.database.repositories.mock.MockListRepository
import com.example.notesmanager.database.repositories.real_data.NoteListRepository
import com.example.notesmanager.database.room.AppDatabase
import com.example.notesmanager.database.room.NoteRoomEntity
import com.example.notesmanager.di.note_editing.NoteEditingComponent
import com.example.notesmanager.di.note_list.NoteListComponent
import com.example.notesmanager.ui.model.NoteItem
import dagger.Binds
import dagger.Component
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

internal object DaggerManager {

    private lateinit var appComponent: AppComponent

    fun plusAppComponent(context: Context) {
        appComponent = DaggerAppComponent
            .builder()
            .appProvideModule(AppProvideModule(context))
            .build()
    }

    fun plusAppComponent() = appComponent
}

@Component(modules = [AppProvideModule::class, AppBindsModule::class])
@Singleton
internal interface AppComponent {

    fun plusNoteListComponent(): NoteListComponent
    fun plusNoteEditingComponent(): NoteEditingComponent
}

@Module
internal class AppProvideModule(private val context: Context) {
    @Provides
    @Singleton
    fun provideContext() = context

    @Provides
    @Singleton
    fun provideDao() = AppDatabase.getInstance(context).getDao()
}

@Module
internal interface AppBindsModule {
    @Binds
    @Singleton
    fun bindsMapper(impl: NotesDatabaseMapper):IMapper<NoteRoomEntity, NoteItem>

    @Binds
    @Singleton
    fun bindsRepository(impl: NoteListRepository): INoteListRepository
}
