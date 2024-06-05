let root = document.getElementById("blocks");
let linkRoot = document.getElementById("linkPlace");

class link {
    constructor(place, url = './brambrambram', title = 'foo'){
        this.place = place;
        this.title = title
        this.url = url;
        this.description = 'Adcione uma descrição';

        this.render();
    }

    render(){
        this.createLink();
        this.place.append(this.linkElement);
    }
    
    createLink(){
        this.linkElement = document.createElement('div');
        this.a = document.createElement('a');
        this.a.innerText = this.title;
        this.a.href = this.url;
        this.p = document.createElement('p');
        this.p.innerText = this.description;


        this.linkElement.classList.add('link');
        this.linkElement.append(this.a);
        this.linkElement.append(this.description);
    }


}


class todoList {
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
        //Create elements
        this.h2 = document.createElement('h2');
        this.h2.innerText = this.title;
        this.input = document.createElement('input');
        this.button = document.createElement('button');
        this.button.innerText = 'Add';
        this.button.classList.add("btn-save");
        this.button.id = "to-do-list-button";
        this.div = document.createElement('div');
        this.todoListElement = document.createElement('div');


        //Add Event listener
        this.button.addEventListener('click', () => {
            if (this.input.value != "") {
                this.addToDo.call(this);
                this.input.value = "";
            }
        });

        //Append elements to the to-do list element
        this.todoListElement.append(this.h2);
        this.todoListElement.append(this.input);
        this.todoListElement.append(this.button);
        this.todoListElement.append(this.div);
        this.todoListElement.classList.add("todoList");
    }
}

class Title{
    constructor(title, deleteButton){
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

        //Create elements
        this.menu = document.createElement("div");
        this.menuContainer = document.createElement("div");
        this.menuTitle = document.createElement("div");
        this.menuInitialDate = document.createElement("div");
        this.menuFinalDate = document.createElement("div");
        this.menuDescription = document.createElement("div");


        //Add class names
        this.menu.className = "menu";
        this.menuContainer.className = "menuContainer";
        this.menuTitle.className = "menuTitle";
        this.menuInitialDate.className = "menuDate";
        this.menuFinalDate.className = "menuDate";
        this.menuDescription.className = "menuDescription";

        //Add inner Text

        //Event listeners
        this.menuContainer.addEventListener('click', (e) => {
            console.log(e.target);
            if (e.target.classList.contains("menuContainer")) {
                this.menuContainer.remove();
            }
        });

        
        //Append
        this.menu.append(this.menuTitle);
        this.menu.append(this.menuInitialDate);
        this.menu.append(this.menuFinalDate);
        this.menu.append(this.menuDescription);
        this.menuContainer.append(this.menu);
        root.append(this.menuContainer);

        this.editableInitialDate = new EditableText(this.state.initialDate, this.menuInitialDate, this, "date", "textarea")
        this.editableFinalDate = new EditableText(this.state.finalDate, this.menuFinalDate, this, "date", "textarea")
        this.editableDescription = new EditableText(this.state.description, this.menuDescription, this, "description", "textarea");
        this.editableTitle = new EditableText(this.state.text, this.menuTitle, this, "text", "input");

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
            this.card.state[this.property] = this.input.value;

            if (this.property == "text") {
                this.card.p.innerText = this.input.value;
            }

            this.div.remove();
            this.render();
        });

        function clickSaveButton(event, object) {
            // Number 13 is the "Enter" key on the keyboard
            if (event.keyCode === 13) {
                // Cancel the default action, if needed
                event.preventDefault();
                // Trigger the button element with a click
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

}






//-------------main------------

let linkCreationButton = document.getElementById('createLinkButton');
let linkCreationInput = document.getElementById('createLinkInput');
let linkCreationName = document.getElementById('createLinkName');


linkCreationButton.addEventListener('click', () => {
    if(linkCreationInput.value.trim() !== "" && linkCreationName.value.trim() !== ""){
        new link(linkRoot, linkCreationName,linkCreationInput.value);
        linkCreationInput.value = "";
        linkCreationName.value = "";
    }
})


let todoList1 = new todoList(root, 'Atividades');


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
        // Remover o menu existente, se houver
        if (this.menuElement) {
            this.menuElement.remove();
        }

        // Criar o contêiner do menu
        this.menuElement = document.createElement('div');
        this.menuElement.className = 'context-menu';

        // Posicionar o menu próximo ao ícone clicado
        this.menuElement.style.top = `${event.clientY}px`;
        this.menuElement.style.left = `${event.clientX}px`;

        // Criar o título do menu
        const title = document.createElement('h3');
        title.innerText = 'Adicionar Membro';
        title.className = 'context-menu-title';

        // Criar o input para o email
        const emailLabel = document.createElement('label');
        emailLabel.innerText = 'Digite o email do membro:';
        emailLabel.className = 'context-menu-email-label';

        const emailInput = document.createElement('input');
        emailInput.type = 'email';
        emailInput.className = 'context-menu-email-input';

        // Criar as opções de categoria
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

        // Criar o botão para adicionar o membro
        const addButton = document.createElement('button');
        addButton.innerText = 'Adicionar Membro';
        addButton.className = 'context-menu-add-button';
        addButton.addEventListener('click', () => {
            this.addMember(emailInput.value, categoryContainer);
        });

        // Adicionar os elementos ao menu
        this.menuElement.appendChild(title);
        this.menuElement.appendChild(emailLabel);
        this.menuElement.appendChild(emailInput);
        this.menuElement.appendChild(categoryLabel);
        this.menuElement.appendChild(categoryContainer);
        this.menuElement.appendChild(addButton);

        // Adicionar o menu ao documento
        document.body.appendChild(this.menuElement);
    }

    addMember(email, categoryContainer) {
        // Variável para armazenar o email do membro
        let memberEmail = email;

        // Variável para armazenar a função do membro
        let memberRole = null;

        // Verificar se um email foi fornecido e se é válido
        if (!memberEmail || !this.validateEmail(memberEmail)) {
            exibirNotificacao('Por favor, digite um email válido.');
            return;
        }

        // Verificar se uma categoria foi selecionada
        const selectedCategory = categoryContainer.querySelector('input[name="category"]:checked');
        if (selectedCategory) {
            memberRole = selectedCategory.value;
        } else {
            exibirNotificacao('Por favor, selecione uma categoria.');
            return;
        }

        // Se ambos os campos forem preenchidos, mostrar uma notificação de sucesso
        exibirNotificacao(`Membro adicionado: ${memberEmail} como ${memberRole}`);

        // Limpar o formulário após adicionar o membro
        this.menuElement.remove();
    }

    // Função para validar o email
    validateEmail(email) {
        const re = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
        return re.test(String(email).toLowerCase());
    }
}

// Inicializar o menu de contexto
document.addEventListener('DOMContentLoaded', () => {
    const addMemberElement = document.getElementById('addMemberButton');
    if (addMemberElement) {
        new ContextMenu(addMemberElement);
    }
});



