// Cargar contenido previo al abrir la página (modo edición)
window.addEventListener('DOMContentLoaded', function () {
    var hiddenField = document.getElementById("noteForm:hiddenContent");
    var editor = document.getElementById("editorArea");
    if (hiddenField && editor && hiddenField.value.trim() !== "") {
        editor.innerHTML = hiddenField.value;
    }
});

// Actualizar el contenido oculto cuando se escribe en el editor
function updateHiddenField() {
    var editor = document.getElementById("editorArea");
    var hiddenField = document.getElementById("noteForm:hiddenContent");
    if (editor && hiddenField) {
        hiddenField.value = editor.innerHTML;
    }
}

// Ejecutar comandos de formato
function execCmd(command, value = null) {
    document.execCommand(command, false, value);
    updateHiddenField();
}
