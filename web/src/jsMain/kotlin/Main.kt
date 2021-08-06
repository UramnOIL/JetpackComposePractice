import androidx.compose.runtime.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.css.keywords.auto
import org.jetbrains.compose.web.dom.*
import org.jetbrains.compose.web.renderComposable

class ViewModel {
    private val mutableStateFlow = MutableStateFlow(0)

    val stateFlow: StateFlow<Int>
        get() = mutableStateFlow

    fun onIncrementState() {
        mutableStateFlow.value++
    }
}

val viewModel = ViewModel()

@Composable
fun App() {
    val count by viewModel.stateFlow.collectAsState(viewModel.stateFlow.value, Dispatchers.Main)

    Div(
        attrs = {
            style {
                width(auto)
                height(100.vh)
                backgroundColor(Color.lime)
            }
        }
    ) {
        P {
            Text(count.toString())
        }
        Button(
            attrs = {
                onClick { viewModel.onIncrementState() }
                style {
                    margin(0.number)
                }
            }
        ) {
            Text("Click")
        }
    }
}

fun main() {
    renderComposable(rootElementId = "root") {
        App() // NOTE 他の関数に切り出さないと怒られる
    }
}