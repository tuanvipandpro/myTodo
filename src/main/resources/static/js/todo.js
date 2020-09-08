setDate()

function addTodo() {
    let newTask = document.getElementById('todo-add-task').value
    document.getElementById('todo-add-task').value = ''

    addDomTask(newTask, 1)
}

function addDomTask(newTask, id) {
    if (typeof newTask === 'string' && newTask.trim() !== '') {
        // GET DOM
        let todo = document.getElementById('todo')
        // Create DOM
        let div = document.createElement('div')
        div.classList.add("todo-task")
        let li = document.createElement('li')

        let label = document.createElement('label')

        let input = document.createElement('input')
        input.type = "checkbox"
        input.name = ""

        let idHidden = document.createElement('input')
        idHidden.type = "hidden"
        idHidden.name = "id" + id
        idHidden.value = id

        let p = document.createElement('p')
        p.appendChild(document.createTextNode(newTask))

        let span = document.createElement('span')

        label.appendChild(input)
        label.appendChild(p)
        label.appendChild(span)

        li.appendChild(label)

        div.appendChild(li)

        todo.appendChild(div)

        let firstTask = document.querySelector('.todo-task')
        todo.insertBefore(div, firstTask)
    }
}

function changeDate() {
    let date = document.getElementById('date').value
    callModal(date)
}

function callModal(content) {
    let modal = document.getElementById("myModal");
    modal.style.display = "block";

    let p = document.getElementById('p-modal-content')
    p.innerText = content ? content : 'Please wait a moment ...'

    setTimeout(hideModal, 1000)
}

function hideModal() {
    let modal = document.getElementById("myModal");
    modal.style.display = "none" 
}

function setDate() {
    let date = document.getElementById("date");
    date.value = new Date().toISOString().slice(0, 10)
}