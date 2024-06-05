const nome_txt = document.getElementById('user_nome')
const email_txt = document.getElementById('user_email')

const userString = window.localStorage.getItem('user');
const user = JSON.parse(userString);
nome_txt.innerHTML = user.nome;
email_txt.innerHTML = user.email;

//----------------------------------------------------------------------

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
        this.a.classList.add('aEdit');
        this.input = document.createElement('input');
        this.editButton = document.createElement('button'); // Botão de edição
        this.editButton.classList.add('edit-button');
        this.editButton.innerText = 'Editar Nome';
        this.editButton.addEventListener('click', () => {
            this.editTitle();
        });

        this.deleteButton = document.createElement('button'); // Botão de exclusão
        this.deleteButton.classList.add('delete-button');
        this.deleteButton.innerText = 'Excluir';
        this.deleteButton.addEventListener('click', () => {
            this.deleteProject();
        });
        
        this.a.href = 'project';
        this.a.innerText = this.title;

        node.appendChild(this.a);
        node.appendChild(this.editButton);
        node.appendChild(this.deleteButton); // Adicionando o botão de exclusão
        this.place.appendChild(node);
    }

    editTitle() {
        let newTitle = prompt('Digite o novo nome do projeto:');
        if (newTitle !== null) {
            this.title = newTitle;
            this.a.innerText = this.title;
        }
    }

    deleteProject() {
        if (confirm('Tem certeza de que deseja excluir este projeto?')) {
            this.place.removeChild(this.a.parentNode); // Remove o nó pai do link (div.project)
        }
    }
}



let origin = document.getElementById("projects");
let projectName = document.getElementById("addProjectInput");
let buttonCreation = document.getElementById("addCreationButton");

/*buttonCreation.addEventListener('click', () => {
    if (projectName.value.trim() !== "") {
        new Project(origin, projectName.value);
        projectName.value = "";
    }
});*/

function createProject(){
    const project = {
        nome: projectName.value,
        administradorId: user
    };

    const url = '/users/' + user.id + '/projects';
    console.log(url);

    fetch(url, {
        method: 'POST',
        headers: {
            'Content-Type' : 'application/json',
        },
        body: JSON.stringify(project),
    })
    .then(response => {
        if(!response.ok){
            alert('Erro ao tentar criar projeto');
            throw new Error('Error criar projeto');
        }
        return response.json();
    })
    .then(data => {
        console.log('Novo projeto criado: ', data);
        new Project(origin, data.nome);
    })
    .catch(error => {
        console.error("Error fetching user:", error);
    });
}

buttonCreation.onclick = createProject;