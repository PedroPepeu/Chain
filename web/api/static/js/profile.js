class Project {
    constructor(place, title = 'default') {
        this.place = place;
        this.title = title;

        this.render();
    }

    render() {
        var node = document.createElement('div');
        node.className = 'project';

        this.a = document.createElement('a');
        this.input = document.createElement('input');
        this.editButton = document.createElement('button'); // Criar o botão de edição
        this.editButton.innerText = 'Editar Nome'; // Definir o texto do botão
        this.editButton.addEventListener('click', () => { // Adicionar evento de clique ao botão de edição
            this.editTitle(); // Chamar a função para editar o título
        });
        
        this.a.href = './projects';
        this.a.innerText = this.title;

        node.appendChild(this.a);
        node.appendChild(this.editButton); // Adicionar o botão de edição ao nó
        node.appendChild(description());
        this.place.appendChild(node);
    }

    editTitle() {
        let newTitle = prompt('Digite o novo nome do projeto:'); // Solicitar ao usuário o novo nome
        if (newTitle !== null) { // Verificar se o usuário não cancelou a ação
            this.title = newTitle; // Atualizar o título do projeto
            this.a.innerText = this.title; // Atualizar o texto do link com o novo título
        }
    }
}

function description() {
    var description = document.createElement('div');
    description.className = 'description';
    return description;
}

let origin = document.getElementById("projects");
let projectName = document.getElementById("addProjectInput");
let buttonCreation = document.getElementById("addCreationButton");

buttonCreation.addEventListener('click', () => {
    if (projectName.value.trim() !== "") {
        new Project(origin, projectName.value);
        projectName.value = "";
    }
});
