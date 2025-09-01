export interface Task {
  id: number;
  name: string;
  description: string;
  completed: boolean;
}

export interface AddTaskRequest {
  name: string;
  description: string;
}

export interface ApiResponse<T> {
  data: T;
  status: number;
  message?: string;
}
