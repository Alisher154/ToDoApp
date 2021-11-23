package uz.texnopos.mytodoapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material.ExperimentalMaterialApi
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import uz.texnopos.mytodoapp.navigation.SetupNavigation
import uz.texnopos.mytodoapp.ui.theme.MyToDoAppTheme
import uz.texnopos.mytodoapp.ui.viewmodels.SharedViewModel

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    
    private lateinit var navController:NavHostController
    private val sharedViewModel: SharedViewModel by viewModels()
    @ExperimentalMaterialApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyToDoAppTheme {
                navController= rememberNavController()
                SetupNavigation(
                    navController = navController,
                sharedViewModel=sharedViewModel)
            }
        }
    }
}

