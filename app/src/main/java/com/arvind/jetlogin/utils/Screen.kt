package com.arvind.jetlogin.utils

sealed class Screen(val route: String) {
    object SplashScreen : Screen("splash_screen")
    object LoginScreen : Screen("login_screen")
    object ForgotPasswordScreen : Screen("forgot_password_screen")
    object OnboardingScreen : Screen("onboarding_screen")
    object SignUpScreen : Screen("sign_up_screen")
    object MainDashboardScreen : Screen("main_Dashboard_screen")
}
