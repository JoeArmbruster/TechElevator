import axios from 'axios';

const http = axios.create({
  baseURL: "http://localhost:3000"
});

export default {

  list() {
    return http.get('/topics');
  },

  get(id) {
    return http.get(`/topics/${id}`);
  },

  create(topic) {
    return http.post('/topics', topic);
  },

  update(topicId, updatedTopic) {
    return http.put(`/topics/${topicId}`, updatedTopic);
  },

  delete(topicId){
    return http.delete(`/topics/${topicId}`);
  }

}
