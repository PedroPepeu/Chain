let origin = document.getElementById("projects");

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
        this.a.href = './projects';
        this.a.innerText = this.title;

        node.appendChild(this.a);
        node.appendChild(description());
        this.place.appendChild(node);
    }
}

function description() {
    var description = document.createElement('div');
    description.className = 'description';
    return description;
}




let projectName = document.getElementById("addProjectInput")
let buttonCreation = document.getElementById("addCreationButton")

buttonCreation.addEventListener('click', () => {
    if (projectName.value.trim() != "") {
        new Project(origin, projectName.value);
        projectName.value = "";
    }
});



