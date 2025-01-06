package com.example.movieapp.presentation.screens.login.view

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.movieapp.R
import com.example.movieapp.presentation.components.AuthForm
import com.example.movieapp.presentation.components.ErrorBottomSheet
import com.example.movieapp.presentation.navigation.MovieAppRoutes
import com.example.movieapp.presentation.screens.shared.AuthEvent
import com.example.movieapp.presentation.screens.shared.AuthFields
import com.example.movieapp.presentation.screens.shared.AuthViewModel
import com.example.movieapp.presentation.theme.AppTheme
import com.example.movieapp.style.theme.Dimens
import com.example.movieapp.utils.getEmailErrorMessage
import com.example.movieapp.utils.getPasswordErrorMessage
import kotlinx.coroutines.flow.collectLatest

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(
    navigationController: NavHostController,
    modifier: Modifier = Modifier,
) {
    val viewModel = hiltViewModel<AuthViewModel>()
    val state = viewModel.uiState.collectAsState()
    val sheetState = rememberModalBottomSheetState()
    var isSheetOpen by rememberSaveable {
        mutableStateOf(false)
    }
    val emailErrorMessage = getEmailErrorMessage(state.value.failedValidations[AuthFields.Email])
    val passwordErrorMessage = getPasswordErrorMessage(state.value.failedValidations[AuthFields.Password])

    LaunchedEffect(Unit) {
      viewModel.authEventFlow.collectLatest {
          when(it) {
              AuthEvent.Error -> isSheetOpen = true
              AuthEvent.Success -> navigationController.navigate(MovieAppRoutes.HomeScreen) {
                  navigationController.popBackStack()
              }
          }
      }
    }


    if (isSheetOpen) {
        ErrorBottomSheet(
            title = stringResource(R.string.error_bottom_sheet_title),
            description = stringResource(R.string.error_bottom_sheet_auth_description),
            sheetState = sheetState,
            onDismiss = { isSheetOpen = false }
        )
    }

    AuthForm(
        formTitle = stringResource(R.string.login),
        imageId = R.drawable.login,
        emailFieldValue = state.value.email,
        passwordFieldValue = state.value.password,
        onEmailChange = { viewModel.validateEmail(it) },
        onPasswordValueChange = { viewModel.validatePassword(it) },
        emailErrorText = if(emailErrorMessage != null) stringResource(emailErrorMessage) else null,
        passwordErrorText = if(passwordErrorMessage != null) stringResource(passwordErrorMessage) else null,
        onOutlinedButtonClick = { navigationController.navigate(MovieAppRoutes.RegisterScreen) },
        onFilledButtonClick = { viewModel.authenticate(isLogin = true) },
        isLoading = state.value.isLoading,
        canProceed = state.value.canProceed,
        outlinedButtonTitle = stringResource(R.string.create_account),
        filledButtonTitle = stringResource(R.string.login),
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(Dimens.m),
    )

}


@Preview
@Composable
fun LoginScreenPreview() {
    AppTheme(darkTheme = false) {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            LoginScreen(
                navigationController = rememberNavController(),
                modifier = Modifier.padding(innerPadding),
            )
        }
    }
}