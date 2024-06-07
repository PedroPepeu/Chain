let root = document.getElementById("blocks");
let linkRoot = document.getElementById("linkPlace");
let containerAtividades = document.getElementById('containerAtividades');

const userString = window.localStorage.getItem('user');
const user = JSON.parse(userString);

let id = window.location.href;
id = id.replace('http://localhost:8080/projects/', '');
id = id.replace('/html', '');
console.log(id);

class link {
    constructor(place, url = './brambrambram', description = 'foo') {
        this.place = place;
        this.url = url;
        this.description = description;

        this.render();
    }

    render() {
        this.createLink();
        this.place.append(this.linkElement);
    }

    createLink() {
        this.linkElement = document.createElement('div');
        this.a = document.createElement('a');
        this.a.innerText = this.url;
        this.a.href = this.url;
        this.p = document.createElement('p');
        this.p.innerText = this.description;

        this.linkElement.classList.add('link');
        this.linkElement.append(this.a);
        this.linkElement.append(this.description);
    }
}

/*class todoList {
    constructor(place, title = "Atividades") {
        this.place = place;
        this.title = title;
        this.cardArray = [];

        this.render();
    }

    addToDo() {
        let text = this.input.value;
        this.cardArray.push(new Card(text, this.div, this));
    }

    render() {
        this.createToDoListElement();
        this.place.append(this.todoListElement);
    }

    createToDoListElement() {
        this.h2 = document.createElement('h2');
        this.h2.innerText = this.title;
        this.input = document.createElement('input');
        this.button = document.createElement('button');
        this.button.innerText = 'Add';
        this.button.classList.add("btn-save");
        this.button.id = "to-do-list-button";
        this.div = document.createElement('div');
        this.todoListElement = document.createElement('div');

        this.button.addEventListener('click', () => {
            if (this.input.value != "") {
                this.addToDo.call(this);
                this.input.value = "";
            }
        });

        this.todoListElement.append(this.h2);
        this.todoListElement.append(this.input);
        this.todoListElement.append(this.button);
        this.todoListElement.append(this.div);
        this.todoListElement.classList.add("todoList");
    }
}

class Title {
    constructor(title, deleteButton) {
        this.title;
        this.deleteButton;
    }
}

class Card {
    constructor(text, place, todoList) {
        this.place = place;
        this.todoList = todoList;
        this.state = {
            initialDate: 'Data inicial',
            finalDate: 'Data final',
            text: text,
            description: "Click to write a description...",
            membro: "Digite o email do membro",
        }

        this.render();
    }

    render() {
        this.card = document.createElement('div');
        this.card.classList.add("card");
        this.card.addEventListener('click', (e) => {
            if (e.target != this.deleteButton) {
                this.showMenu.call(this);
            }
        });

        this.p = document.createElement('p');
        this.p.innerText = this.state.text;

        this.deleteButton = document.createElement('button');
        this.deleteButton.innerText = "X";
        this.deleteButton.addEventListener('click', () => {
            this.deleteCard.call(this);
        });

        this.card.append(this.p);
        this.card.append(this.deleteButton);

        this.place.append(this.card);
    }

    deleteCard() {
        this.card.remove();
        let i = this.todoList.cardArray.indexOf(this);
        this.todoList.cardArray.splice(i, 1);
    }

    showMenu() {
        this.menu = document.createElement("div");
        this.menuContainer = document.createElement("div");
        this.menuTitle = document.createElement("div");
        this.menuInitialDate = document.createElement("div");
        this.menuFinalDate = document.createElement("div");
        this.menuDescription = document.createElement("div");
        this.menuMembro = document.createElement("div");

        this.menu.className = "menu";
        this.menuContainer.className = "menuContainer";
        this.menuTitle.className = "menuTitle";
        this.menuInitialDate.className = "menuDate";
        this.menuFinalDate.className = "menuDate";
        this.menuDescription.className = "menuDescription";
        this.menuMembro.className = "menuMembro";

        this.menuContainer.addEventListener('click', (e) => {
            if (e.target.classList.contains("menuContainer")) {
                this.menuContainer.remove();
            }
        });

        this.menu.append(this.menuTitle);
        this.menu.append(this.menuInitialDate);
        this.menu.append(this.menuFinalDate);
        this.menu.append(this.menuDescription);
        this.menu.append(this.menuMembro);
        this.menuContainer.append(this.menu);
        root.append(this.menuContainer);

        this.editableInitialDate = new EditableText(this.state.initialDate, this.menuInitialDate, this, "date", "textarea")
        this.editableFinalDate = new EditableText(this.state.finalDate, this.menuFinalDate, this, "date", "textarea")
        this.editableDescription = new EditableText(this.state.description, this.menuDescription, this, "description", "textarea");
        this.editableTitle = new EditableText(this.state.text, this.menuTitle, this, "text", "input");
        this.editableMembro = new EditableText(this.state.membro, this.menuMembro, this, "membro", "input"); 
    }
}

class EditableText {
    constructor(text, place, card, property, typeOfInput) {
        this.text = text;
        this.place = place;
        this.card = card;
        this.property = property;
        this.typeOfInput = typeOfInput;
        this.render();
    }

    render() {
        this.div = document.createElement("div");
        this.p = document.createElement("p");

        this.p.innerText = this.text;

        this.p.addEventListener('click', () => {
            this.showEditableTextArea.call(this);
        });

        this.div.append(this.p);
        this.place.append(this.div);
    }

    showEditableTextArea() {
        let oldText = this.text;

        this.input = document.createElement(this.typeOfInput);
        this.saveButton = document.createElement("button");

        this.p.remove();
        this.input.value = oldText;
        this.saveButton.innerText = "Save";
        this.saveButton.className = "btn-save";

        this.saveButton.addEventListener('click', () => {
            this.text = this.input.value;

            if (this.property == "membro" && !this.validateEmail(this.input.value)) {
                exibirNotificacao('Por favor, digite um email válido.');
                return;
            }

            this.card.state[this.property] = this.input.value;

            if (this.property == "text") {
                this.card.p.innerText = this.input.value;
            }

            this.div.remove();
            this.render();
        });

        function clickSaveButton(event, object) {
            if (event.keyCode === 13) {
                event.preventDefault();
                object.saveButton.click();
            }
        }

        this.input.addEventListener("keyup", (e) => {
            if (this.typeOfInput == "input") {
                clickSaveButton(e, this);
            }
        });

        this.div.append(this.input);

        if (this.typeOfInput == "textarea") {
            this.div.append(this.saveButton);
        }

        this.input.select();
    }

    validateEmail(email) {
        const re = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
        return re.test(String(email).toLowerCase());
    }
}*/

class atividade {
    constructor(nomeTxt, descricaoTxt, data_inicio, data_termino, email='a') {
        this.nomeTxt = nomeTxt;
        this.descricaoTxt = descricaoTxt;
        this.data_inicio = data_inicio;
        this.data_termino = data_termino;
        this.email = email;

        this.render();
    }

    render() {
        this.createActivity();
        containerAtividades.append(this.attElement);
    }

    createActivity() {
        this.attElement = document.createElement('div');
        this.attElement.classList.add('atividade_item');

        this.nome = document.createElement('p');
        this.descricao = document.createElement('p');
        this.dataInicio = document.createElement('p');
        this.dataTermino = document.createElement('p');
        this.membros = document.createElement('p');
        this.linha = document.createElement('hr');

        this.nome.innerText = 'NOME: ' + this.nomeTxt;
        this.descricao.innerText = 'DESCRICAO: ' + this.descricaoTxt;
        this.dataInicio.innerText = 'DATA INICIO: ' + this.data_inicio;
        this.dataTermino.innerText = 'DATA TERMINO: ' + this.data_termino;
        this.membros.innerText = 'RESPONSAVEIS: ' + this.email;

        this.attElement.append(this.nome);
        this.attElement.append(this.descricao);
        this.attElement.append(this.dataInicio);
        this.attElement.append(this.dataTermino);
        this.attElement.append(this.membros);

        this.attElement.append(this.linha);
    }
}

//-------------main------------

function getLinks(){
    const url = '/projects/' + id + '/links';

    fetch(url, {
        method: 'GET',
        headers: {
            'Content-Type' : 'application/json',
        },
    })
    .then(response => {
        if(!response.ok){
            alert('Erro ao tentar pegar links');
            throw new Error('Error ao tentar pegar links');
        }

        return response.json();
    })
    .then(data => {
        console.log(data);
        for(let i = 0; i < data.length; i++)
        {
            new link(linkRoot, data[i].urlLink, data[i].descricao); //JSON.stringify(data[i])
        }
    })
    .catch(error => {
        console.error("Error fetching link:", error);
    });
}

getLinks();

let linkCreationInput = document.getElementById('createLinkInput');
let createLinkDescription = document.getElementById('createLinkDescription');
let linkCreationButton = document.getElementById('createLinkButton');
let emailMembro = document.getElementById('email_membro');

function createLink(){
    const url = '/projects/' + id;

    fetch(url, {
        method: 'GET',
        headers: {
            'Content-Type' : 'application/json',
        },
    })
    .then(response => {
        if(!response.ok){
            alert('Erro ao tentar pegar projeto');
            throw new Error('Error ao tentar pegar projeto');
        }

        return response.json();
    })
    .then(projeto => {
        console.log('Projeto foi pego: ', projeto);
        const newLink = {
            id: -1,
            descricao: createLinkDescription.value,
            urlLink: linkCreationInput.value,
            projetoId: projeto
        };
        
        const linkUrl = url + '/links'
        fetch(linkUrl, {
            method: 'POST',
            headers: {
                'Content-Type' : 'application/json',
            },
            body: JSON.stringify(newLink),
        })
        .then(response => {
            if(!response.ok){
                alert('Erro ao tentar criar link');
                throw new Error('Error ao tentar criar link');
            }
        
            return response.json();
        })
        .then(data => {
            console.log('Novo link criado: ', data);
            new link(linkRoot, data.urlLink, data.descricao); //JSON.stringfy(data)
        })
        .catch(error => {
            console.error("Error fetching link:", error);
        });
    })
    .catch(error => {
        console.error("Error fetching project:", error);
    });
}

linkCreationButton.onclick = createLink;

//let todoList1 = new todoList(root, 'Atividades');

// Função para exibir notificação usando Toastify
function exibirNotificacao(mensagem) {
    Toastify({
        text: mensagem,
        duration: 4000
    }).showToast();
}

// Classe para criar o menu de contexto
class ContextMenu {
    constructor(triggerElement) {
        this.triggerElement = triggerElement;
        this.menuElement = null;
        this.init();
    }

    init() {
        this.triggerElement.addEventListener('click', (e) => {
            e.preventDefault();
            this.createMenu(e);
        });
    }

    createMenu(event) {
        if (this.menuElement) {
            this.menuElement.remove();
        }
    
        this.menuElement = document.createElement('div');
        this.menuElement.className = 'context-menu';
        this.menuElement.style.top = `${event.clientY}px`;
        this.menuElement.style.left = `${event.clientX}px`;
    
        const title = document.createElement('h3');
        title.innerText = 'Adicionar Membro';
        title.className = 'context-menu-title';
    
        const emailLabel = document.createElement('label');
        emailLabel.innerText = 'Digite o email do membro:';
        emailLabel.className = 'context-menu-email-label';
    
        const emailInput = document.createElement('input');
        emailInput.type = 'email';
        emailInput.className = 'context-menu-email-input';
    
        const categoryLabel = document.createElement('label');
        categoryLabel.innerText = 'Escolha uma categoria:';
        categoryLabel.className = 'context-menu-category-label';
    
        const categories = ['FRONTEND', 'BACKEND', 'FULL_STACK', 'SCRUM_MASTER', 'NONE'];
        const categoryContainer = document.createElement('div');
        categoryContainer.className = 'context-menu-category-container';
    
        categories.forEach(category => {
            const radioLabel = document.createElement('label');
            radioLabel.innerText = category;
            radioLabel.className = 'context-menu-radio-label';
    
            const radioInput = document.createElement('input');
            radioInput.type = 'radio';
            radioInput.name = 'category';
            radioInput.value = category;
            radioInput.className = 'context-menu-radio-input';
    
            radioLabel.appendChild(radioInput);
            categoryContainer.appendChild(radioLabel);
        });
    
        const addButton = document.createElement('button');
        addButton.innerText = 'Adicionar Membro';
        addButton.className = 'context-menu-add-button';
        addButton.addEventListener('click', () => {
            //this.addMember(emailInput.value, categoryContainer);

            const radios = document.querySelectorAll('input[name="category"]');
            let selected;
            for(const radio of radios){
                if(radio.checked){
                    selected = radio.value;
                    break;
                }
            }

            console.log(selected);

            const url = '/projects/' + id;
    
            fetch(url, {
                method: 'GET',
                headers: {
                    'Content-Type' : 'application/json',
                },
            })
            .then(response => {
                if(!response.ok){
                    alert('Erro ao tentar pegar projeto');
                    throw new Error('Error ao tentar pegar projeto');
                }
            
                return response.json();
            })
            .then(projeto => {
                console.log('Projeto foi pego: ', projeto);
                
                const urlAddMember = '/users/' + user.id + '/projects/' + emailInput.value + '/' + selected;
                fetch(urlAddMember, {
                    method: 'PUT',
                    headers: {
                        'Content-Type' : 'application/json',
                    },
                    body: JSON.stringify(projeto),
                })
                .then(response => {
                    if(!response.ok){
                        alert('Erro ao tentar adicionar membro ao projeto');
                        throw new Error('Erro ao tentar adicionar membro ao projeto');
                    }
                    else
                    {
                        console.log('membro adicionado');
                    }
                
                    return response.json();
                })
                .then(data => {
                    console.log(data.engenheiroId.nome);
                    addMember(data.engenheiroId.nome, data.engenheiroId.email);
                })
                .catch(error => {
                    console.error("Error fetching add member to project:", error);
                });
            })
            .catch(error => {
                console.error("Error fetching project:", error);
            });
        });
    
        const closeButton = document.createElement('button');
        closeButton.innerText = 'Fechar X';
        closeButton.className = 'context-menu-close-button';
        closeButton.addEventListener('click', () => {
            this.menuElement.remove();
        });
    
        this.menuElement.appendChild(title);
        this.menuElement.appendChild(emailLabel);
        this.menuElement.appendChild(emailInput);
        this.menuElement.appendChild(categoryLabel);
        this.menuElement.appendChild(categoryContainer);
        this.menuElement.appendChild(addButton);
        this.menuElement.appendChild(closeButton);
    
        document.body.appendChild(this.menuElement);
    }
    
    addMember(email, categoryContainer) {
        let memberEmail = email;
        let memberRole = null;

        if (!memberEmail || !this.validateEmail(memberEmail)) {
            exibirNotificacao('Por favor, digite um email válido.');
            return;
        }

        const selectedCategory = categoryContainer.querySelector('input[name="category"]:checked');
        if (selectedCategory) {
            memberRole = selectedCategory.value;
        } else {
            exibirNotificacao('Por favor, selecione uma categoria.');
            return;
        }

        exibirNotificacao(`Membro adicionado: ${memberEmail} como ${memberRole}`);
        this.menuElement.remove();
    }

    validateEmail(email) {
        const re = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
        return re.test(String(email).toLowerCase());
    }
}

document.addEventListener('DOMContentLoaded', () => {
    const addMemberElement = document.getElementById('addMemberButton');
    if (addMemberElement) {
        new ContextMenu(addMemberElement);
    }
});

const displayMembers = document.getElementsByClassName('display')[0];

function addMember(nome, email){
    const div = document.createElement('div');
    div.className = 'membro';

    const nomeTxt = document.createElement('p');
    nomeTxt.textContent = 'Nome: ' + nome;

    const emailTxt = document.createElement('p');
    emailTxt.textContent = 'Email: ' + email;

    div.appendChild(nomeTxt);
    div.appendChild(emailTxt);

    displayMembers.appendChild(div);
}

function addParticipatingMembers(){
    const url = '/projects/' + id + '/members';
    console.log(url);

    fetch(url, {
        method: 'GET',
        headers:{
            'Content-Type':'application/json',
        }
    })
    .then(response => {
        if(!response.ok){
            alert('Erro ao tentar pegar membros');
            throw new Error('Erro ao tentar pegar membros');
        }

        return response.json();
    })
    .then(data => {
        console.log(data);
        for(let i = 0; i < data.length; i++)
        {
            addMember(data[i].engenheiroId.nome, data[i].engenheiroId.email);
        }
    })
    .catch(error => {
        console.error('error fetching get members: ', error);
    });
}

addParticipatingMembers();

function getAtividades(){
    const url = '/projects/' + id + '/activities';
    fetch(url, {
        method: 'GET',
        headers:{
            'Content-Type' : 'application/json',
        }
    })
    .then(response => {
        if(!response.ok){
            alert('Error ao tentar pegar atividades');
            throw new Error('Error ao tentar pegar atividades');
        }

        return response.json();
    })
    .then(data => {
        for(let i = 0; i < data.length; i++){
            new atividade(data[i].nome, data[i].descricao, data[i].dataInicio, data[i].dataEntrega);
        }
    })
    .catch(error => {
        console.error('fetching trying get activities: ', error);
    })
}

getAtividades();

const nomeAtt = document.getElementById('nomeAtt');
const descAtt = document.getElementById('descAtt');
const in_dataInicio = document.getElementById('dataInicio');
const in_dataTermino = document.getElementById('dataTermino');

function addAtividade(){
    const url = '/projects/' + id;

    fetch(url, {
        method: 'GET',
        headers: {
            'Content-Type' : 'application/json',
        },
    })
    .then(response => {
        if(!response.ok){
            alert('Erro ao tentar pegar projeto');
            throw new Error('Error ao tentar pegar projeto');
        }

        return response.json();
    })
    .then(projeto => {
        console.log('Projeto foi pego(criar atividade): ', projeto);

        const attUrl = url + '/activity';
        console.log(attUrl);

        const ativ = {
            id: -1,
            nome: nomeAtt.value,
            descricao: descAtt.value,
            dataInicio: in_dataInicio.value,
            dataEntrega: in_dataTermino.value,
            concluida: true,
            projetoId: projeto
        };
    
        fetch(attUrl, {
            method: 'POST',
            headers:{
                'Content-Type' : 'application/json',
            },
            body: JSON.stringify(ativ),
        })
        .then(response => {
            if(!response.ok){
                alert('erro ao tentar criar atividade');
                throw new Error('erro ao tentar criar atividade');
            }
    
            return response.json();
        })
        .then(ativi => {
            console.log('atividade: ', ativi);
            const membroUrl = '/users/' + user.id + '/projects/' + id + '/activity/' + ativi.id + '/' + emailMembro.value;
            fetch(membroUrl, {
                method: 'PUT',
                headers:{
                    'Content-Type':'application/json',
                }
            })
            .then(response => {
                if(!response.ok){
                    alert('erro ao tentar colocar membro a atividade');
                    throw new Error('erro ao tentar colocar membro a atividade');
                }

                return response.json();
            })
            .then(membro => {
                console.log('membro foi adicionado: ', membro);
                new atividade(ativi.nome, ativi.descricao, ativi.dataInicio, ativi.dataEntrega, emailMembro.value);
            })
            .catch(error => {
                console.error('fetching add member activity: ', error);
            });
        })
        .catch(error => {
            console.error('error fetching create activity', error);
        })
    })
    .catch(error => {
        console.error("Error fetching project:", error);
    });
}

document.getElementById('criarAtividade').onclick = addAtividade;