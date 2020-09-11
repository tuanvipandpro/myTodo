setDate()

/**
 * Set Default Date
 */
function setDate() {
    let date = document.getElementById("date");
    date.value = new Date().toISOString().slice(0, 10)
}

/**
 * Add new task for todo list
 */
function addTodo() {
    let newTask = document.getElementById('todo-add-task').value
    document.getElementById('todo-add-task').value = ''

    let task = {
        id: 1,
        content: 'ABC',
        username: 'leminhtuan',
        date: '2020-09-09',
        statusId: 5
    }

    addDomTask(task)
}

/**
 * Add Dom 
 */
function addDomTask(task) {
    if (typeof task.content === 'string' && task.content.trim() !== '') {
        // GET DOM
        let todo = document.getElementById('todo')

        let wrapper = document.getElementById('todo-wrapper')
        // Create DOM
        let div = document.createElement('div')
        div.classList.add("todo-task")
        let li = document.createElement('li')

        let label = document.createElement('label')

        let input = document.createElement('input')
        input.type = "checkbox"
        input.name = ""
        input.checked = task.statusId === 4 ? undefined : "checked"

        let idHidden = document.createElement('input')
        idHidden.type = "hidden"
        idHidden.name = "id" + task.id
        idHidden.value = task.id

        let p = document.createElement('p')
        p.appendChild(document.createTextNode(task.content))

        let span = document.createElement('span')

        label.appendChild(input)
        label.appendChild(p)
        label.appendChild(span)

        li.appendChild(label)

        div.appendChild(li)

        todo.appendChild(div)

        // let firstTask = document.querySelector('.todo-task')
        // todo.insertBefore(div, firstTask)

        wrapper.appendChild(div)
    }
}

/**
 * Handle when date change 
 */
function changeDate() {
    callModal()
    let dateValue = document.getElementById('date').value
    // Create Param
    let url = "/task-service/get-list-task-by-day"
    let params = {
        date : dateValue
    }
    // Get Request
    axios.get(url, {params}).then(res => {
        let data = res.data

        let taskItems = document.getElementById("todo-wrapper")
        while(taskItems.firstChild) {
            taskItems.removeChild(taskItems.lastChild)
        }

        data.forEach(element => {
            addDomTask(element)
        });

        hideModal()
    }).catch(e => console.error(e))
}

function updateTask() {
    console.error("update")
}

/**
 * Enable Popup
 */
function callModal(content) {
    let modal = document.getElementById("myModal");
    modal.style.display = "block";

    let p = document.getElementById('p-modal-content')
    p.innerText = content ? content : 'Please wait a moment ...'

    // setTimeout(hideModal, 1000)
}

/**
 * Disable Popup
 */
function hideModal() {
    let modal = document.getElementById("myModal");
    modal.style.display = "none" 
}