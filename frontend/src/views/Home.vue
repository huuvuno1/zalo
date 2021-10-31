<template>
    <!-- wraphome -->
        <div class="wrap__home flex">
            <taskbar :class="[isBack ? 'block' : 'hidden']"/>

            <!-- task detail -->
            <taskbar-detail :conversations="conversations" :class="[isBack ? 'block' : 'hidden']"/>

            <!-- right container -->
            <chat-container v-if="!showIntro" :class="[isBack ? 'hidden' : 'block']"/>
            <introduce v-else />
        </div>
</template>

<script>
import { mapState } from 'vuex'
import Taskbar from '@/components/Taskbar.vue'
import TaskbarDetail from '@/components/TaskbarDetail.vue'
import ChatContainer from '@/components/ChatContainer.vue'
import Introduce from '@/components/Introduce.vue'

export default {
  name: 'Home',
  computed: mapState(['isBack']),
  components: {
    Taskbar,
    TaskbarDetail,
    ChatContainer,
    Introduce
  },
  data() {
    return {
      showIntro: true,
      conversations: []
    }
  },
  mounted() {
    console.log(this.$route.params.id)
    this.showIntro = this.$route.params.id ? false : true

    this.conversations = [
      {
        id: 1,
        name: 'Nguyen Van B',
        avatar: 'https://i.pinimg.com/736x/fa/02/02/fa0202572e8aa734cedb154c413a4846.jpg',
        timeStamp: "3 giờ",
        lastestMessage: 'em oi'
      },
      {
        id: 2,
        name: 'Nguyen Van C',
        avatar: 'https://i.pinimg.com/736x/fa/02/02/fa0202572e8aa734cedb154c413a4846.jpg',
        timeStamp: "3 giờ",
        lastestMessage: 'em oi'
      },
      {
        id: 3,
        name: 'Nguyen Van C',
        avatar: 'https://i.pinimg.com/736x/fa/02/02/fa0202572e8aa734cedb154c413a4846.jpg',
        timeStamp: "3 giờ",
        lastestMessage: 'em oi'
      },
      {
        id: 4,
        name: 'Nguyen Van C',
        avatar: 'https://i.pinimg.com/736x/fa/02/02/fa0202572e8aa734cedb154c413a4846.jpg',
        timeStamp: "3 giờ",
        lastestMessage: 'em oi'
      },
      {
        id: 5,
        name: 'Nguyen Van C',
        avatar: 'https://i.pinimg.com/736x/fa/02/02/fa0202572e8aa734cedb154c413a4846.jpg',
        timeStamp: "3 giờ",
        lastestMessage: 'em oi'
      },
      {
        id: 1,
        name: 'Nguyen Van C',
        avatar: 'https://i.pinimg.com/736x/fa/02/02/fa0202572e8aa734cedb154c413a4846.jpg',
        timeStamp: "3 giờ",
        lastestMessage: 'em oi'
      },
      {
        id: 2,
        name: 'Nguyen Van C',
        avatar: 'https://i.pinimg.com/736x/fa/02/02/fa0202572e8aa734cedb154c413a4846.jpg',
        timeStamp: "3 giờ",
        lastestMessage: 'em oi'
      },
      {
        id: 3,
        name: 'Nguyen Van C',
        avatar: 'https://i.pinimg.com/736x/fa/02/02/fa0202572e8aa734cedb154c413a4846.jpg',
        timeStamp: "3 giờ",
        lastestMessage: 'em oi'
      },
      {
        id: 4,
        name: 'Nguyen Van C',
        avatar: 'https://i.pinimg.com/736x/fa/02/02/fa0202572e8aa734cedb154c413a4846.jpg',
        timeStamp: "3 giờ",
        lastestMessage: 'em oi'
      },
      {
        id: 5,
        name: 'Nguyen Van C',
        avatar: 'https://i.pinimg.com/736x/fa/02/02/fa0202572e8aa734cedb154c413a4846.jpg',
        timeStamp: "3 giờ",
        lastestMessage: 'em oi'
      },
      {
        id: 1,
        name: 'Nguyen Van C',
        avatar: 'https://i.pinimg.com/736x/fa/02/02/fa0202572e8aa734cedb154c413a4846.jpg',
        timeStamp: "3 giờ",
        lastestMessage: 'em oi'
      },
      {
        id: 2,
        name: 'Nguyen Van C',
        avatar: 'https://i.pinimg.com/736x/fa/02/02/fa0202572e8aa734cedb154c413a4846.jpg',
        timeStamp: "3 giờ",
        lastestMessage: 'em oi'
      },
      {
        id: 3,
        name: 'Nguyen Van C',
        avatar: 'https://i.pinimg.com/736x/fa/02/02/fa0202572e8aa734cedb154c413a4846.jpg',
        timeStamp: "3 giờ",
        lastestMessage: 'em oi'
      },
      {
        id: 4,
        name: 'Nguyen Van C',
        avatar: 'https://i.pinimg.com/736x/fa/02/02/fa0202572e8aa734cedb154c413a4846.jpg',
        timeStamp: "3 giờ",
        lastestMessage: 'em oi'
      },
      {
        id: 5,
        name: 'Nguyen Van C',
        avatar: 'https://i.pinimg.com/736x/fa/02/02/fa0202572e8aa734cedb154c413a4846.jpg',
        timeStamp: "3 giờ",
        lastestMessage: 'em oi'
      }

    ]
  }
}

</script>

<style lang="scss">
::-webkit-scrollbar {
    width: 7px;
    position: absolute;
  }
  
  /* Track */
  ::-webkit-scrollbar-track {
    background: transparent; 
  }
   
  div:hover::-webkit-scrollbar-thumb {
    background: #888;
    border-radius: 4px;
  }
  
  /* Handle */
  ::-webkit-scrollbar-thumb {
    background: rgb(223, 223, 223);
    border-radius: 4px;
  }
  
  /* Handle on hover */
  ::-webkit-scrollbar-thumb:hover {
    background: #555; 
  }

  .pr--7 {
      margin-right: -7px;
  }

  #list__contact {
      height: calc(100vh - 98px);
  }

  .max-w-180 {
      max-width: 180px;
  }

  #list__message {
    // height: calc(100vh - 56px);
  }

  @media (min-width: 768px) {
    #list__message {
        // height: calc(100vh - 173px);
    }

    #txtMessage {
      max-height: 100px !important;
    }
    .my__frame--chat {
      width: calc(100vw - 385px);
    }
  }

  #txtMessage {
      max-height: 50px;
      width: 95%;
  }

.my__list--chat{ 
    flex-grow: 1;
    div {
        max-width: 70%;
        width: fit-content;
        white-space: pre-wrap;
        word-wrap: break-word;
    }
}

.my__min--w {
    min-width: 44px;
}

.my__close {
  width: 15px; 
  height: 15px; 
  text-align: center; 
  background-color: grey; 
  cursor: pointer; 
  line-height: 12px; 
  font-size: 12px; 
  border-radius: 50%; 
  color: white; 
  font-weight: bold;
}
* {
  -webkit-tap-highlight-color: transparent;
}
</style>