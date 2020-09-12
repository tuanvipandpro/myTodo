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

    if (newTask.trim() !== '') {
        callModal()
        let url = '/task-service/create-new-task'
        let params = {
            content: newTask,
            date: document.getElementById('date').value
        }
    
        axios.post(url, params).then(res => {
            addDomTask(res.data)
            hideModal()
        }).catch(e => console.error(e))
    }
}

/**
 * Add Dom 
 */
function addDomTask(task) {
    if (typeof task.content === 'string' && task.content.trim() !== '') {
        // GET DOM
        let wrapper = document.getElementById('todo-wrapper')
        // Create DOM
        let div = document.createElement('div')
        div.classList.add("todo-task")

        let li = document.createElement('li')

        let label = document.createElement('label')

        let input = document.createElement('input')
        input.id = task.id
        input.type = "checkbox"
        input.name = ""
        input.checked = task.statusId === 4 
        input.addEventListener("click", updateFunc)
        input.param = task

        let p = document.createElement('p')
        p.appendChild(document.createTextNode(task.content))

        let span = document.createElement('span')

        label.appendChild(input)
        label.appendChild(p)
        label.appendChild(span)

        li.appendChild(label)

        div.appendChild(li)

        wrapper.appendChild(div)
    }
}

function updateFunc(evt) {
    updateTask(evt.currentTarget.param)
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

function updateTask(id) {
    callModal()
    let checkbox = document.getElementById(id)

    let url = checkbox.checked ? '/task-service/done-task' : '/task-service/open-task'

    let params = {
        id: id
    }

    // Get Request
    axios.get(url, {params}).then(res => {
        console.error(res)
        hideModal()
    }).catch(e => console.error(e))
}

/**
 * Enable Popup
 */
function callModal(content) {
    let modal = document.getElementById("myModal");
    modal.style.display = "block";

    let p = document.getElementById('p-modal-content')
    p.innerText = content ? content : 'Please wait a moment ...'
}

/**
 * Disable Popup
 */
function hideModal() {
    let modal = document.getElementById("myModal");
    modal.style.display = "none" 
}