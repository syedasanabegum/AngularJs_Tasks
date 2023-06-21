// Form class
class TaskForm {
    private taskTitleInput: HTMLInputElement;
    private dateInput: HTMLInputElement;
    private form: HTMLFormElement;
  
    constructor(formId: string) {
      this.form = document.getElementById(formId) as HTMLFormElement;
      this.taskTitleInput = this.form.elements.namedItem('taskTitle') as HTMLInputElement;
      this.dateInput = this.form.elements.namedItem('date') as HTMLInputElement;
  
      this.form.addEventListener('submit', this.handleSubmit.bind(this));
    }
  
    handleSubmit(event: Event) {
      event.preventDefault();
  
      const taskTitle = this.taskTitleInput.value;
      const date = this.dateInput.value;
  
      const task = new Task(taskTitle, date);
      taskTable.addTask(task);
  
      this.form.reset();
    }
  }
  
  // Task class
  class Task {
    static serialNumber: number = 1;
  
    taskTitle: string;
    date: string;
    status: string;
  
    constructor(taskTitle: string, date: string) {
      this.taskTitle = taskTitle;
      this.date = date;
      this.status = 'Not Done';
    }
  
    markAsCompleted() {
      this.status = 'Completed';
    }
  }
  
  // TaskTable class
  class TaskTable {
    private table: HTMLTableElement;
    private tasks: Task[];
  
    constructor(tableId: string) {
      this.table = document.getElementById(tableId) as HTMLTableElement;
      this.tasks = [];
    }
  
    addTask(task: Task) {
      this.tasks.push(task);
      this.renderTable();
    }
  
    renderTable() {
      // Clear table body
      while (this.table.tBodies[0].firstChild) {
        this.table.tBodies[0].removeChild(this.table.tBodies[0].firstChild);
      }
  
      // Render tasks
      this.tasks.forEach((task, index) => {
        const row = this.table.tBodies[0].insertRow();
        row.insertCell().textContent = (index + 1).toString();
        row.insertCell().textContent = task.taskTitle;
        row.insertCell().textContent = task.date;
        row.insertCell().textContent = task.status;
        const actionCell = row.insertCell();
        const doneButton = document.createElement('button');
        doneButton.textContent = 'Done';
        doneButton.addEventListener('click', () => {
          task.markAsCompleted();
          this.renderTable();
        });
        actionCell.appendChild(doneButton);
      });
    }
  }
  
  // Initialize form and table
  const taskForm = new TaskForm('taskForm');
  const taskTable = new TaskTable('taskTable');
  