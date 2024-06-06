const nome_txt = document.getElementById('user_nome')
const email_txt = document.getElementById('user_email')

const userString = window.localStorage.getItem('user');
const user = JSON.parse(userString);
nome_txt.innerHTML = user.nome;
email_txt.innerHTML = user.email;

//----------------------------------------------------------------------

class Project {
    constructor(place, title = 'default', projectString) {
        this.place = place;
        this.title = title;
        this.project = JSON.parse(projectString);

        console.log(this.project.nome);

        this.render();
    }

    render() {
        var node = document.createElement('div');
        node.className = 'project';


        this.a = document.createElement('a');
        this.a.classList.add('aEdit');
        this.a.innerText = this.title;
        this.a.addEventListener('click', () => {
            window.location.href = '/projects/' + this.project.id + '/html';
        })

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

//--------------------------------------------------------------------------------------------------

function addParticipatingProjects(){
    const url = '/users/' + user.id + '/projects';
    console.log(url);

    fetch(url, {
        method: 'GET',
        headers: {
            'Content-Type' : 'application/json',
        }
    })
    .then(response => {
        if(!response.ok){
            alert('Error ao tentar pegar os projetos do usuario');
            throw new Error('Error ao tentar pegar os projetos do usuario');
        }

        return response.json();
    })
    .then(data => {
        for(let i = 0; i < data.length; i++)
        {
            new Project(origin, data[i].nome, JSON.stringify(data[i]));
        }
    })
    .catch(error => {
        console.error("Error fetching project:", error);
    });
}

addParticipatingProjects();

let origin = document.getElementById("projects");
let projectName = document.getElementById("addProjectInput");
let buttonCreation = document.getElementById("addCreationButton");

function createProject(){
    const project = {
        id: -1,
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
        new Project(origin, data.nome, JSON.stringify(data));
    })
    .catch(error => {
        console.error("Error fetching user:", error);
    });
}

buttonCreation.onclick = createProject;

