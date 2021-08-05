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
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.arvind.jetlogin.R
import com.arvind.jetlogin.components.StandardTextField
import com.arvind.jetlogin.ui.theme.purplish
import com.arvind.jetlogin.ui.theme.white
import com.arvind.jetlogin.utils.Screen
import com.arvind.jetlogin.viewmodel.LoginViewModel

@Composable
fun LoginScreen(
    navController: NavController,
    viewModel: LoginViewModel = hiltViewModel()
) {
    LazyColumn {
        item {
            ConstraintLayout(
                modifier = Modifier
                    .fillMaxSize()
                    .background(MaterialTheme.colors.surface)
            ) {
                val (logoref, titleref, emailormobiletitleref,
                    emailormobileboxref, passwordtitleref, passwordboxref,
                    buttonloginref, forgotpasswordref,
                    signupref) = createRefs()

                Image(
                    painter = painterResource(id = R.drawable.applogo),
                    contentDescription = "Logo",
                    modifier = Modifier
                        .fillMaxSize()
                        .constrainAs(logoref) {
                            top.linkTo(parent.top, margin = 50.dp)
                            start.linkTo(parent.start)
                            end.linkTo(parent.end)
                        }
                )
                Text(text = "Enter your email address / phone number\n" +
                        "and password to access.",
                    style = typography.subtitle1,
                    modifier = Modifier.constrainAs(titleref) {
                        top.linkTo(logoref.bottom, margin = 40.dp)
                        start.linkTo(parent.start, 16.dp)
                    })

                Text(text = "E-Mail / Phone Number",
                    style = typography.h6,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.constrainAs(emailormobiletitleref) {
                        top.linkTo(titleref.bottom, margin = 20.dp)
                        start.linkTo(parent.start, 16.dp)
                    })

                StandardTextField(
                    Modifier
                        .padding(16.dp, 0.dp, 16.dp, 0.dp)
                        .constrainAs(emailormobileboxref) {
                            top.linkTo(emailormobiletitleref.bottom, margin = 5.dp)
                        },
                    text = viewModel.useremailormobileText.value,
                    onValueChange = {
                        viewModel.setUsernameText(it)
                    },
                    hint = stringResource(id = R.string.login_hint),
                    keyboardType = KeyboardType.Text
                )

                Text(text = "Password",
                    style = typography.h6,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.constrainAs(passwordtitleref) {
                        top.linkTo(emailormobileboxref.bottom, margin = 20.dp)
                        start.linkTo(parent.start, margin = 16.dp)
                    })

                StandardTextField(
                    Modifier
                        .padding(16.dp, 0.dp, 16.dp, 0.dp)
                        .constrainAs(passwordboxref) {
                            top.linkTo(passwordtitleref.bottom, margin = 5.dp)
                        },
                    text = viewModel.passwordText.value,
                    onValueChange = {
                        viewModel.setPasswordText(it)
                    },
                    hint = stringResource(id = R.string.password_hint),
                    keyboardType = KeyboardType.Password
                )

                Button(onClick = { },
                    shape = RoundedCornerShape(50),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp)
                        .padding(16.dp, 0.dp, 16.dp, 0.dp)
                        .constrainAs(buttonloginref) {
                            top.linkTo(passwordboxref.bottom, margin = 40.dp)
                            start.linkTo(parent.start)
                            end.linkTo(parent.end)
                        }) {
                    Text(
                        text = stringResource(id = R.string.login),
                        style = typography.subtitle1,
                        color = Color.White
                    )
                }

                TextButton(
                    onClick = {
                        navController.navigate(Screen.ForgotPasswordScreen.route)
                    },
                    modifier = Modifier.constrainAs(forgotpasswordref) {
                        top.linkTo(buttonloginref.bottom, margin = 20.dp)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    }
                ) {
                    Text(
                        text = stringResource(id = R.string.forgot_password),
                        textAlign = TextAlign.Center
                    )
                }

                Text(
                    text = buildAnnotatedString {
                        append("Don't have an account? Signup")
                        addStyle(SpanStyle(color = MaterialTheme.colors.primary), 23, this.length)
                        toAnnotatedString()
                    },
                    style = typography.subtitle1,
                    modifier = Modifier
                        .constrainAs(signupref) {
                            top.linkTo(forgotpasswordref.bottom, margin = 20.dp)
                            start.linkTo(parent.start, margin = 16.dp)
                            end.linkTo(parent.end, margin = 16.dp)
                        }
                        .clickable(
                            onClick = {
                                navController.navigate(Screen.SignUpScreen.route)
                            }
                        )
                )


            }
        }
    }
}