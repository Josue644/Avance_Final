//editar modal Docente
document.querySelectorAll(".btn-edit").forEach(button => {
    button.addEventListener("click", function () {
        const row = this.closest("tr");

        const id = row.getAttribute("data-id");
        const nombre = row.children[0].innerText;
        const apellidoPaterno = row.children[1].innerText;
        const apellidoMaterno = row.children[2].innerText;
        const cursoEspecializado = row.children[3].innerText;
        const nivel = row.children[4].innerText;
        const sede = row.children[5].innerText;

        document.getElementById("editId").value = id;
        document.getElementById("editNombre").value = nombre;
        document.getElementById("editApellidoPaterno").value = apellidoPaterno;
        document.getElementById("editApellidoMaterno").value = apellidoMaterno;
        document.getElementById("editCursoEspecializado").value = cursoEspecializado;
        document.getElementById("editNivel").value = nivel;
        document.getElementById("editSede").value = sede;
    });
});

