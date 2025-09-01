import { Link } from 'react-router';
import type { Task } from '../types/task';

interface TaskCardProps {
  task: Task;
  onDelete: (id: number) => void;
  isDeleting?: boolean;
}

export default function TaskCard({ task, onDelete, isDeleting = false }: TaskCardProps) {
  return (
    <div className="bg-white rounded-lg shadow-md border border-gray-200 p-6 hover:shadow-lg transition-shadow">
      <div className="flex justify-between items-start mb-4">
        <div className="flex-1">
          <h3 className={`text-lg font-semibold text-gray-900 mb-2 ${
            task.completed ? 'line-through text-gray-500' : ''
          }`}>
            {task.name}
          </h3>
          <p className="text-gray-600 text-sm line-clamp-3">
            {task.description}
          </p>
        </div>
        <div className="flex items-center space-x-2 ml-4">
          <span className={`inline-flex items-center px-2.5 py-0.5 rounded-full text-xs font-medium ${
            task.completed
              ? 'bg-green-100 text-green-800'
              : 'bg-yellow-100 text-yellow-800'
          }`}>
            {task.completed ? 'Completed' : 'Pending'}
          </span>
        </div>
      </div>
      
      <div className="flex justify-between items-center pt-4 border-t border-gray-100">
        <Link
          to={`/task/${task.id}`}
          className="text-blue-600 hover:text-blue-800 text-sm font-medium transition-colors"
        >
          View Details →
        </Link>
        
        <button
          onClick={() => onDelete(task.id)}
          disabled={isDeleting}
          className={`px-3 py-1 text-sm font-medium rounded-md transition-colors ${
            isDeleting
              ? 'bg-gray-100 text-gray-400 cursor-not-allowed'
              : 'bg-red-100 text-red-700 hover:bg-red-200'
          }`}
        >
          {isDeleting ? 'Deleting...' : 'Delete'}
        </button>
      </div>
    </div>
  );
}
