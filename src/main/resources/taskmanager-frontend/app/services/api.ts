import axios from 'axios';
import type { Task, AddTaskRequest } from '../types/task';

const API_BASE_URL = 'http://localhost:8080/api';

const api = axios.create({
  baseURL: API_BASE_URL,
  headers: {
    'Content-Type': 'application/json',
  },
});

export const taskApi = {
  // Get all tasks
  getAllTasks: async (): Promise<Task[]> => {
    const response = await api.get<Task[]>('/');
    return response.data;
  },

  // Get task by ID
  getTaskById: async (id: number): Promise<Task> => {
    const response = await api.get<Task>(`/${id}`);
    return response.data;
  },

  // Create new task
  createTask: async (task: AddTaskRequest): Promise<Task> => {
    const response = await api.post<Task>('/', task);
    return response.data;
  },

  // Delete task
  deleteTask: async (id: number): Promise<void> => {
    await api.delete(`/${id}`);
  },
};

export default api;
