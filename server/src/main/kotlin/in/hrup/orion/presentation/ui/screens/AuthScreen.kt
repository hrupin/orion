package `in`.hrup.orion.presentation.ui.screens

import kotlinx.html.*


fun SECTION.authScreen(isError: String = "") {
    form(action = "/auth", method = FormMethod.post, classes = "form_auth") {

        div{
            img { src = "/static/img/logo_full.svg" }
        }

        div {
            label { +"Login:" }
            textInput(name = "email", classes = "input is-medium") {
                placeholder = "login"
            }
        }
        div {
            label { +"Password:" }
            passwordInput(name = "password", classes = "input is-medium") {
                placeholder = "••••••"
            }
        }

        if (isError.isNotEmpty()) {
            p{
                +isError
            }
        }

        div(classes = "form-group-btn") {
            submitInput(classes = "button is-medium is-fullwidth") {
                value = "Войти"
            }
        }
    }
}