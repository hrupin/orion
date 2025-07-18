document.addEventListener('DOMContentLoaded', () => {

    // Get all "navbar-burger" elements
    const $navbarBurgers = Array.prototype.slice.call(document.querySelectorAll('.navbar-burger'), 0);

    // Add a click event on each of them
    $navbarBurgers.forEach( el => {
        el.addEventListener('click', () => {

            // Get the target from the "data-target" attribute
            const target = el.dataset.target;
            const $target = document.getElementById(target);

            // Toggle the "is-active" class on both the "navbar-burger" and the "navbar-menu"
            el.classList.toggle('is-active');
            $target.classList.toggle('is-active');

        });
    });

    function openModal($el) {
        $el.classList.add('is-active');
    }

    function closeModal($el) {
        $el.classList.remove('is-active');
    }
    function closeAllModals() {
        (document.querySelectorAll('.modal') || []).forEach(($modal) => {
            closeModal($modal);
        });
    }
    (document.querySelectorAll('.js-modal-trigger') || []).forEach(($trigger) => {
        const modal = $trigger.dataset.target;
        console.log(modal)
        const $target = document.getElementById(modal);

        $trigger.addEventListener('click', () => {
            openModal($target);
        });
    });
    (document.querySelectorAll('.modal-background, .modal-close, .modal-card-head .delete, .modal-card-foot .button') || []).forEach(($close) => {
        const $target = $close.closest('.modal');

        $close.addEventListener('click', () => {
            closeModal($target);
        });
    });
    document.addEventListener('keydown', (event) => {
        if(event.key === "Escape") {
            closeAllModals();
        }
    });
    const fileInput = document.querySelector("#uploadDump input[type=file]");
    fileInput.onchange = () => {
        if (fileInput.files.length > 0) {
            const fileName = document.querySelector("#uploadDump .file-name");
            fileName.textContent = fileInput.files[0].name;
        }
    };
    (document.querySelectorAll('.notification .delete') || []).forEach(($delete) => {
        const $notification = $delete.parentNode;

        $delete.addEventListener('click', () => {
            $notification.parentNode.removeChild($notification);
        });
        setTimeout(() => {
            if ($notification.parentNode) {
                $notification.parentNode.removeChild($notification);
            }
        }, 3000);
    });
    document.querySelectorAll('ul.tree li.folder > span').forEach(span => {
        span.addEventListener('click', () => {
            span.parentElement.classList.toggle('open');
        });
    });
    document.querySelectorAll('span.file').forEach(fileSpan => {
        fileSpan.addEventListener('click', () => {
            const path = fileSpan.getAttribute('data-path');
            if (!path) return;

            fetch(`/site/file?path=${encodeURIComponent(path)}`)
                .then(response => {
                    if (!response.ok) {
                        throw new Error(`Ошибка загрузки файла: ${response.statusText}`);
                    }
                    return response.text();
                })
                .then(text => {
                    const textarea = document.getElementById('fileContentArea');
                    if (textarea) {
                        textarea.value = text;
                        const pathField = document.getElementById('filePath');
                        pathField.value = path;
                    } else {
                        alert('Textarea для вывода содержимого не найдена!');
                    }
                })
                .catch(err => alert(err));
        });
    });
    document.getElementById('saveFileButton').addEventListener('click', () => {
        const path = document.getElementById('filePath').value;
        const content = document.getElementById('fileContentArea').value;

        if (!path) {
            alert("Файл не выбран");
            return;
        }

        fetch('/site/save', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                path: path,
                content: content
            })
        })
            .then(response => {
                if (!response.ok) throw new Error("Ошибка при сохранении файла");
                return response.text();
            })
            .then(msg => alert(msg))
            .catch(err => alert("Ошибка: " + err.message));
    });
});