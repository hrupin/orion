package `in`.hrup.orion.presentation.ui.components

import kotlinx.html.ButtonType
import kotlinx.html.FlowContent
import kotlinx.html.FormEncType
import kotlinx.html.FormMethod
import kotlinx.html.br
import kotlinx.html.button
import kotlinx.html.div
import kotlinx.html.form
import kotlinx.html.script
import kotlinx.html.unsafe
import `in`.hrup.orion.data.modelsImpl.CategoryImpl

fun FlowContent.formCreateCategory(category: CategoryImpl? = null) {

    form(classes = "box", action = "/admin/category/action", method = FormMethod.post, encType = FormEncType.multipartFormData) {

        fieldHidden("id", category?.id.toString())
        field("Category name", "name", category?.name, "name")
        field("Category alias", "alias", category?.alias, "alias")
        field("SEO Title", "seoTitle", category?.seoTitle)
        field("SEO Description", "seoDescription", category?.seoDescription)
        field("SEO Keywords", "seoKeywords", category?.seoKeywords)

        br{}

        div("field") {
            div("control") {
                button(classes = "button is-primary", type = ButtonType.submit) {
                    +"Save"
                }
            }
        }

        script {
            unsafe {
                +"""
            document.getElementById("name").addEventListener("input", function() {
                const input = this.value;
                const alias = transliterate(input);
                document.getElementById("alias").value = alias;
            });

            function transliterate(text) {
                const map = {
                    'а': 'a', 'б': 'b', 'в': 'v', 'г': 'g', 'ґ': 'g', 'д': 'd',
                    'е': 'e', 'є': 'ie', 'ж': 'zh', 'з': 'z', 'и': 'y', 'і': 'i',
                    'ї': 'i', 'й': 'i', 'к': 'k', 'л': 'l', 'м': 'm', 'н': 'n',
                    'о': 'o', 'п': 'p', 'р': 'r', 'с': 's', 'т': 't', 'у': 'u',
                    'ф': 'f', 'х': 'kh', 'ц': 'ts', 'ч': 'ch', 'ш': 'sh', 'щ': 'shch',
                    'ь': '', 'ю': 'iu', 'я': 'ia', 'э': 'e', 'ы': 'y', 'ё': 'e',
                    'ъ': '', ' ' : '-', '_' : '-', ',' : '', '.' : '', '/' : '', 
                    ':' : '', ';' : '', "'" : '', '"' : '', '[' : '', ']' : '',
                    '{' : '', '}' : '', '\\': '', '|' : '', '`' : '', '~' : '',
                    '?' : '', '!' : '', '@' : '', '#' : '', '$' : '', '%' : '',
                    '^' : '', '&' : '', '*' : '', '(' : '', ')' : '', '+' : '',
                    '=' : ''
                };

                return text.toLowerCase().split('').map(function (char) {
                    return map[char] || char;
                }).join('').replace(/-+/g, '-').replace(/^-|-$/g, '');
            }
            """.trimIndent()
            }
        }

    }

}