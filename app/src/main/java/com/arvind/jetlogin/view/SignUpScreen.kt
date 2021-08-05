package com.arvind.jetlogin.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.arvind.jetlogin.R
import com.arvind.jetlogin.components.StandardTextField
import com.arvind.jetlogin.ui.theme.white
import com.arvind.jetlogin.utils.Screen
import com.arvind.jetlogin.viewmodel.LoginViewModel

@Composable
fun SignUpScreen(
    navController: NavController,
    viewModel: LoginViewModel = hiltViewModel()
) {
    Scaffold(topBar = {
        TopAppBar(title = {
            Text(
                text = "Sign Up",
                color = white
            )
        },
            navigationIcon = {
                IconButton(onClick = {
                    navController.navigate(Screen.LoginScreen.route) {
                        popUpTo("signup") { inclusive = true }
                    }
                }) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack, contentDescription = "Back",
                        tint = white
                    )

                }
            })
    }) {
        LazyColumn {
            item {
                ConstraintLayout(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(
                            MaterialTheme.colors.background
                        )
                ) {

                    val (logoref, titleref, textemailormobilref,
                        emailormobileboxref, textpasswordref,
                        passwordboxref, textconfirmpasswordref,
                        confirmpasswordboxref, buttonsignupref,
                        textloginref) = createRefs()

                    Image(painter = painterResource(id = R.drawable.applogo),
                        contentDescription = "Logo",
                        modifier = Modifier
                            .fillMaxSize()
                            .constrainAs(logoref) {
                                top.linkTo(parent.top, margin = 50.dp)
                                start.linkTo(parent.start)
                                end.linkTo(parent.end)
                            })

                    Text(
                        text = "New User\n" +
                                "Create Account",
                        style = typography.h6,
                        modifier = Modifier.constrainAs(titleref) {
                            top.linkTo(logoref.bottom, margin = 20.dp)
                            start.linkTo(parent.start, margin = 16.dp)
                        }
                    )

                    Text(
                        text = "E-Mail / Phone Number",
                        style = typography.h6,
                        modifier = Modifier.constrainAs(textemailormobilref) {
                            top.linkTo(titleref.bottom, margin = 20.dp)
                            start.linkTo(parent.start, margin = 16.dp)
                        }
                    )

                    StandardTextField(
                        Modifier
                            .padding(16.dp, 0.dp, 16.dp, 0.dp)
                            .constrainAs(emailormobileboxref) {
                                top.linkTo(textemailormobilref.bottom, margin = 5.dp)
                            },
                        text = viewModel.useremailormobileText.value,
                        onValueChange = {
                            viewModel.setUsernameText(it)
                        },
                        hint = stringResource(id = R.string.login_hint),
                        keyboardType = KeyboardType.Text
                    )

                    Text(
                        text = "Password",
                        style = typography.h6,
                        modifier = Modifier.constrainAs(textpasswordref) {
                            top.linkTo(emailormobileboxref.bottom, margin = 20.dp)
                            start.linkTo(parent.start, margin = 16.dp)
                        }
                    )
                    StandardTextField(
                        Modifier
                            .padding(16.dp, 0.dp, 16.dp, 0.dp)
                            .constrainAs(passwordboxref) {
                                top.linkTo(textpasswordref.bottom, margin = 5.dp)
                            },
                        text = viewModel.passwordText.value,
                        onValueChange = {
                            viewModel.setPasswordText(it)
                        },
                        hint = stringResource(id = R.string.password_hint),
                        keyboardType = KeyboardType.Password
                    )

                    Text(
                        text = "Confirm Password",
                        style = typography.h6,
                        modifier = Modifier.constrainAs(textconfirmpasswordref) {
                            top.linkTo(passwordboxref.bottom, margin = 20.dp)
                            start.linkTo(parent.start, margin = 16.dp)
                        }
                    )

                    StandardTextField(
                        Modifier
                            .padding(16.dp, 0.dp, 16.dp, 0.dp)
                            .constrainAs(confirmpasswordboxref) {
                                top.linkTo(textconfirmpasswordref.bottom, margin = 5.dp)
                            },
                        text = viewModel.confirmpasswordText.value,
                        onValueChange = {
                            viewModel.setConfirmPasswordText(it)
                        },
                        hint = stringResource(id = R.string.confirm_password_hint),
                        keyboardType = KeyboardType.Password
                    )

                    Button(
                        onClick = { },
                        shape = RoundedCornerShape(50),
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp)
                            .padding(16.dp, 0.dp, 16.dp, 0.dp)
                            .constrainAs(buttonsignupref) {
                                top.linkTo(confirmpasswordboxref.bottom, margin = 40.dp)
                            }
                    ) {
                        Text(
                            text = "Sign Up",
                            color = white,
                            style = typography.subtitle1
                        )
                    }

                    Text(
                        text = buildAnnotatedString {
                            append("Already have an account? Login")
                            addStyle(
                                SpanStyle(color = MaterialTheme.colors.primary),
                                24,
                                this.length
                            )
                        },
                        style = typography.subtitle1,
                        modifier = Modifier
                            .padding(0.dp, 0.dp, 0.dp, 20.dp)
                            .constrainAs(textloginref) {
                                top.linkTo(buttonsignupref.bottom, margin = 24.dp)
                                start.linkTo(parent.start, margin = 16.dp)
                                end.linkTo(parent.end, margin = 16.dp)
                            }
                            .clickable(
                                onClick = {
                                    navController.navigate(Screen.LoginScreen.route)
                                }
                            )
                    )
                }
            }
        }

    }
}