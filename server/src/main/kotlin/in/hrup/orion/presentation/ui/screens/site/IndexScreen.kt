package `in`.hrup.orion.presentation.ui.screens.site

import kotlinx.html.SECTION
import kotlinx.html.a
import kotlinx.html.div
import kotlinx.html.img
import kotlinx.html.figure
import kotlinx.html.footer


fun SECTION.indexScreen() {
    div(classes = "card") {
        div(classes = "card-image") {
            figure(classes = "image is-4by3") {
                img {
                    src = "/static/img/logo_full.svg"
                }
            }
        }
        div(classes = "content") {
            +"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus nec iaculis mauris."
        }
        footer(classes = "card-footer") {
            a(classes = "card-footer-item", href = "#") {
                +"sdfdsf"
            }
            a(classes = "card-footer-item", href = "#") {
                +"sdfdsf"
            }
            a(classes = "card-footer-item", href = "#") {
                +"sdfdsf"
            }
        }
    }
}