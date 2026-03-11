package subratk.com.np

import androidx.compose.runtime.*
import androidx.navigation.compose.*

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "splash") {
        composable("splash") {
            SplashScreen(
                onSplashFinished = { navController.navigate("login") {
                    popUpTo("splash") { inclusive = true }
                }}
            )
        }

        composable("login") {
            LoginScreen(
                onRegisterClick = { navController.navigate("register") }
            )
        }

        composable("register") {
            RegisterScreen(
                onRegisterClick = { navController.navigate("home") },
                onLoginClick = { navController.navigate("login") }
            )
        }

        composable("home") {
            TodoListScreen(
                onAddClick = { navController.navigate("addtodo") },
                onEditClick = { navController.navigate("edittodo") },
                onProfileClick = { navController.navigate("profile") }
            )
        }

        composable("addtodo") {
            AddEditTodoScreen(
                isEditing = false,
                onBackClick = { navController.popBackStack() }
            )
        }

        composable("edittodo") {
            AddEditTodoScreen(
                isEditing = true,
                onBackClick = { navController.popBackStack() }
            )
        }

        composable("profile") {
            ProfileScreen(
                onBackClick = { navController.popBackStack() }
            )
        }

    }
}