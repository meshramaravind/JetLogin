package com.arvind.jetlogin.view

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import com.arvind.jetlogin.R
import com.arvind.jetlogin.ui.theme.white
import com.arvind.jetlogin.utils.Screen

@Composable
fun ForgotPasswordScreen(navController: NavController) {
    Scaffold(topBar = {
        TopAppBar(title = {
            Text(
                text = "Forgot Password",
                color = white
            )
        },
            navigationIcon = {
                IconButton(onClick = {
                    navController.navigate(Screen.LoginScreen.route) {
                        popUpTo("login") { inclusive = true }
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
                        .background(MaterialTheme.colors.background)
                ) {
                    val (bannerlogoref, titleref,
                        textemailormobileboxref,
                        emailormobileboxref, buttonsubmitref) = createRefs()

                    Image(
                        painter = painterResource(id = R.drawable.applogo),
                        contentDescription = "Logo",
                        modifier = Modifier
                            .fillMaxSize()
                            .constrainAs(bannerlogoref) {
                                top.linkTo(parent.top, margin = 50.dp)
                                start.linkTo(parent.start)
                                end.linkTo(parent.end)
                            }
                    )

                    Text(
                        text = "Enter your email address or phone\n" +
                                "number and we'll send you an email and\n" +
                                "SMS with OTP to reset your password",
                        style = MaterialTheme.typography.subtitle1,
                        modifier = Modifier.constrainAs(titleref) {
                            top.linkTo(bannerlogoref.bottom, margin = 20.dp)
                            start.linkTo(parent.start, margin = 16.dp)
                        }
                    )

                    Text(text = "Email or Phone Number *",
                        style = MaterialTheme.typography.h6,
                        modifier = Modifier.constrainAs(textemailormobileboxref) {
                            top.linkTo(titleref.bottom, margin = 20.dp)
                            start.linkTo(parent.start, margin = 16.dp)
                        })

                    var useremailormobile by remember { mutableStateOf("") }

                    TextField(modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp, 0.dp, 16.dp, 0.dp)
                        .constrainAs(emailormobileboxref) {
                            top.linkTo(textemailormobileboxref.bottom, margin = 20.dp)
                        }
                        .background(MaterialTheme.colors.background),
                        label = {
                            Text(text = "Email or Phone Number")
                        }, textStyle = TextStyle(
                            color = MaterialTheme.colors.onPrimary,
                            fontSize = 16.sp
                        ),
                        value = useremailormobile,
                        onValueChange = {
                            useremailormobile = it
                        })

                    Button(
                        onClick = { },
                        shape = RoundedCornerShape(50),
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp)
                            .padding(
                                16.dp, 0.dp, 16.dp, 0.dp
                            )
                            .constrainAs(buttonsubmitref) {
                                top.linkTo(emailormobileboxref.bottom, margin = 40.dp)
                            }
                    ) {
                        Text(
                            text = "Submit",
                            style = MaterialTheme.typography.subtitle1,
                            color = Color.White

                        )
                    }


                }
            }
        }
    }
}