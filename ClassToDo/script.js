// Form class
var TaskForm = /** @class */ (function () {
    function TaskForm(formId) {
        this.form = document.getElementById(formId);
        this.taskTitleInput = this.form.elements.namedItem('taskTitle');
        this.dateInput = this.form.elements.namedItem('date');
        this.form.addEventListener('submit', this.handleSubmit.bind(this));
    }
    TaskForm.prototype.handleSubmit = function (event) {
        event.preventDefault();
        var taskTitle = this.taskTitleInput.value;
        var date = this.dateInput.value;
        var task = new Task(taskTitle, date);
        taskTable.addTask(task);
        this.form.reset();
    };
    return TaskForm;
}());
// Task class
var Task = /** @class */ (function () {
    function Task(taskTitle, date) {
        this.taskTitle = taskTitle;
        this.date = date;
        this.status = 'Not Done';
    }
    Task.prototype.markAsCompleted = function () {
        this.status = 'Completed';
    };
    Task.serialNumber = 1;
    return Task;
}());
// TaskTable class
var TaskTable = /** @class */ (function () {
    function TaskTable(tableId) {
        this.table = document.getElementById(tableId);
        this.tasks = [];
    }
    TaskTable.prototype.addTask = function (task) {
        this.tasks.push(task);
        this.renderTable();
    };
    TaskTable.prototype.renderTable = function () {
        var _this = this;
        // Clear table body
        while (this.table.tBodies[0].firstChild) {
            this.table.tBodies[0].removeChild(this.table.tBodies[0].firstChild);
        }
        // Render tasks
        this.tasks.forEach(function (task, index) {
            var row = _this.table.tBodies[0].insertRow();
            row.insertCell().textContent = (index + 1).toString();
            row.insertCell().textContent = task.taskTitle;
            row.insertCell().textContent = task.date;
            row.insertCell().textContent = task.status;
            var actionCell = row.insertCell();
            var doneButton = document.createElement('button');
            doneButton.textContent = 'Done';
            doneButton.addEventListener('click', function () {
                task.markAsCompleted();
                _this.renderTable();
            });
            actionCell.appendChild(doneButton);
        });
    };
    return TaskTable;
}());
// Initialize form and table
var taskForm = new TaskForm('taskForm');
var taskTable = new TaskTable('taskTable');
