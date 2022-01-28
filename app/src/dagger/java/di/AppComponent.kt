package di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import dagger.multibindings.IntoSet

@Component
interface AppComponent {
    //pass context to component graph
    @Component.Builder
    interface Factory{
        fun create(@BindsInstance context: Context): AppComponent
    }
}