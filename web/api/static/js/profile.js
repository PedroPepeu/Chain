class project{
    constructor(){
        this.render();
    }
    
    render(){
        this.button = document.createElement('button');
        this.button.innerText = '+';
        this.button.classList.add("content-add");

        this.button.addEventListener('click', () => {
            
        });
    }
}

let addProjectButton = document.getElementById("addProjectButton");

addProjectButton.addEventListener('click', () => {
    if (addProjectInput.value.trim() != "") {
        new project(root);
        addProjectInput.value = "";
    }
});

let project = project();

