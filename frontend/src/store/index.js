import { createStore } from 'vuex'
import { scrollMessageHistory } from '../utils/Scroll'

export default createStore({
  state: {
    isBack: true,
    chatHistory: [
      {
        avatar: 'https://i.pinimg.com/736x/fa/02/02/fa0202572e8aa734cedb154c413a4846.jpg',
        sender: 'user1',
        messages: [
            {
                content: 'oi ban oi', 
                timestamp: '4h00'
            }
        ]
    },
      {
        avatar: 'https://i.pinimg.com/736x/fa/02/02/fa0202572e8aa734cedb154c413a4846.jpg',
        sender: 'user1',
        messages: [
            {
                content: 'Hello World ok', 
                timestamp: '4h00'
            },
            {
                content: 'Hello World send', 
                timestamp: '4h01'
            }
        ]
    },
    {
        avatar: 'https://i.pinimg.com/736x/fa/02/02/fa0202572e8aa734cedb154c413a4846.jpg',
        sender: 'me',
        messages: [
            {
                content: 'Hello World ok', 
                timestamp: '4h00'
            },
            {
                content: 'Hello World send Hello World send Hello World send Hello World send Hello World send Hello World send', 
                timestamp: '4h01'
            }
            ,
            {
                content: 'Hello World send', 
                timestamp: '4h01'
            },
            {
                content: 'Hello World send', 
                timestamp: '4h01'
            }
        ]
    },
    {
        avatar: 'https://i.pinimg.com/736x/fa/02/02/fa0202572e8aa734cedb154c413a4846.jpg',
        sender: 'user1',
        messages: [
            {
                content: 'Hello World ok', 
                timestamp: '4h00'
            },
            {
                content: 'Hello World send', 
                timestamp: '4h01'
            }
        ]
    },
    {
        avatar: 'https://i.pinimg.com/736x/fa/02/02/fa0202572e8aa734cedb154c413a4846.jpg',
        sender: 'me',
        messages: [
            {
                content: 'Hello World ok', 
                timestamp: '4h00'
            },
            {
                content: 'Hello World send', 
                timestamp: '4h01'
            }
            ,
            {
                content: 'Hello World send', 
                timestamp: '4h01'
            },
            {
                content: 'Hello World send', 
                timestamp: '4h01'
            }
        ]
    },
    {
        avatar: 'https://i.pinimg.com/736x/fa/02/02/fa0202572e8aa734cedb154c413a4846.jpg',
        sender: 'user1',
        messages: [
            {
                content: 'Hello World ok', 
                timestamp: '4h00'
            },
            {
                content: 'Hello World send', 
                timestamp: '4h01'
            }
        ]
    },
    {
        avatar: 'https://i.pinimg.com/736x/fa/02/02/fa0202572e8aa734cedb154c413a4846.jpg',
        sender: 'me',
        messages: [
            {
                content: 'Hello World ok', 
                timestamp: '4h00'
            },
            {
                content: 'Hello World send', 
                timestamp: '4h01'
            }
            ,
            {
                content: 'Hello World send', 
                timestamp: '4h01'
            },
            {
                content: 'Hello World send', 
                timestamp: '4h01'
            }
        ]
    },
    {
        avatar: 'https://i.pinimg.com/736x/fa/02/02/fa0202572e8aa734cedb154c413a4846.jpg',
        sender: 'user1',
        messages: [
            {
                content: 'oi ban oi', 
                timestamp: '4h00'
            }
        ]
    }
    ]
  },
  mutations: {
    changeBack(state) {
      state.isBack = !state.isBack
      scrollMessageHistory()
    }
  },
  actions: {
  },
  modules: {
  }
})
