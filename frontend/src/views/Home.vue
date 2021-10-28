<template>
    <!-- wraphome -->
        <div class="wrap__home flex">
            <!-- left container -->
            <div class="bg-blue-500 flex flex-col w-16 items-center h-screen py-4 hidden md:block">
                <!-- avatar -->
                <div class="rounded-full w-11 h-11 mb-10 border border-white cursor-pointer">
                    <img src="../assets/images/background.png" alt="" class="w-full h-full rounded-full">
                </div>
                <!-- menu -->
                <div class="flex flex-col w-full items-center cursor-pointer  ">
                    <!-- message -->
                    <div class="h-16 w-full text-center pt-4 hover:bg-blue-400 bg-blue-600">
                        <i class='bx bxs-message-rounded-detail text-3xl text-white'></i>
                    </div>

                    <!-- danh ba -->
                    <div class="h-16 w-full text-center pt-4 hover:bg-blue-400">
                        <i class='bx bxs-contact text-3xl text-white'></i>
                    </div>

                    <!-- chuong -->
                    <div class="h-16 w-full text-center pt-4 hover:bg-blue-400">
                        <i class='bx bx-bell text-3xl text-white'></i>
                    </div>

                    <!-- note -->
                    <div class="h-16 w-full text-center pt-4 hover:bg-blue-400">
                        <i class='bx bx-notepad text-3xl text-white'></i>
                    </div>
                </div>

            </div>

            <!-- task detail -->
            <div class="md:max-w-xs flex-1 md:w-80 border-r border-gray-200 hidden md:block">
                <!-- box option -->
                <div class="px-2 py-4 flex">
                    <!-- search -->
                    <div class="flex-1 border-b border-gray-300 flex items-center ">
                        <i class='bx bx-search mr-2 cursor-pointer'></i>
                        <input type="text" placeholder="Tìm kiếm" id="txtSearch" class="outline-none flex-1" >
                        <span class="my__close">x</span>
                    </div>
                    <!-- create group -->
                    <div class="w-10 text-right">
                        <i class='bx bx-group cursor-pointer text-xl' title="Tạo nhóm chat"></i>
                    </div>
                </div>
                <!-- box contact -->
                <div class="">
                    <!-- title -->
                    <div class="font-bold border-b border-gray-200  p-2">
                        Tất cả tin nhắn
                    </div>

                    <div class="overflow-y-scroll overflow-x-hidden h-96 relative" id="list__contact">
                        <conversation-component v-for="conversation in conversations" :key="conversation.id" :conversation="conversation" />
                    </div>
                    
                    
                </div>
            </div>

            <!-- right container -->
            <div class=" flex-1 relative">
                <!-- top -->
                <div class="h-14 md:h-16 border-b border-gray-200 flex items-center justify-between bg-white">
                    <!-- left include back and name -->
                    <div class="flex items-center">
                        <!-- back -->
                        <div class="w-6 ml-2 cursor-pointer md:hidden">
                            <i class='bx bx-arrow-back font-bold text-2xl'></i>
                        </div>

                        <!-- rom name -->
                        <div class="ml-2 cursor-pointer md:ml-4">
                            <h2 class="font-bold text-sm md:text-lg">Nguyễn Công Minh</h2>
                            <div class="flex items-center">
                                <span class="rounded-full w-2 h-2 bg-green-600"></span>
                                <span class="ml-1 text-xs">Đang hoạt động</span>
                            </div>
                        </div>
                    </div>
                    

                    <!-- option -->
                    <div class="flex w-28 md:w-36 justify-evenly">
                        <!-- call -->
                        <div class="text-center">
                            <i class='bx bxs-phone-call text-xl md:text-2xl text-blue-600 cursor-pointer' ></i>
                        </div>

                        <div class="text-center">
                            <i class='bx bxs-video text-xl md:text-2xl text-blue-600 cursor-pointer' ></i>
                        </div>

                        <div class="text-center">
                            <i class='bx bx-sidebar text-xl md:text-2xl text-blue-600 cursor-pointer'></i>
                        </div>
                    </div>
                </div>

                <!-- bottom -->
                <!-- message history -->
                <div class="bg-gradient-to-b from-gray-300 to-gray-500 h-screen overflow-y-scroll overflow-x-hidden " id="list__message">
                    <!-- receive -->
                    <div class="flex">
                        <div class="my__min--w rounded-full w-11 h-11 bg-white border border-gray-200 mx-1 md:mx-2 my-1">
                            <img src="../assets/images/zlogo.png" alt="" class="rounded-full w-full h-full">
                        </div>
                        <!-- list chat text -->
                        <div class="my__list--chat">
                            <div class="bg-white py-1 px-2 rounded my-1">
                                day la noi dung day la noi dung 
                                day la noi dung 
                                day la noi dung 
                                day la noi dung day la noi dung day la noi dung day la noi dung 
                                day la noi dung 
                                day la noi dung 
                                day la noi dung day la noi dung 
                                day la noi dung 

                                day la noi dung day la noi dung 

                                day la noi dung 
                                day la noi dung 
                                day la noi dung 
                                day la noi dung 
                                day la noi dung 
                                day la noi dung 
                                day la noi dung 
                                day la noi dung 
                                day la noi dung 
                            </div>
                            <div class="bg-white py-1 px-2 rounded my-1">
                                day la noi dung
                            </div>
                            <div class="bg-white py-1 px-2 rounded my-1">
                                day la noi dung
                            </div>
                        </div>
                    </div>

                    <!-- send -->
                    <div class="flex flex-row-reverse">
                        <div class="my__min--w rounded-full w-11 h-11 bg-white border border-gray-200 mx-1 md:mx-2 my-1">
                            <img src="../assets/images/zlogo.png" alt="" class="rounded-full w-full h-full">
                        </div>
                        <!-- list chat text -->
                        <div class="my__list--chat flex flex-col items-end">
                            <div class="bg-white py-1 px-2 rounded my-1">
                                day la noi dung
                            </div>
                            <div class="bg-white py-1 px-2 rounded my-1">
                                day la noi dung
                            </div>
                            <div class="bg-white py-1 px-2 rounded my-1">
                                day la noi dung
                                
                                day la noi dung day la noi dung 

                                day la noi dung 
                                day la noi dung 
                                day la noi dung 
                                day la noi dung 
                                day la noi dung 
                                day la noi dung 
                                day la noi dung 
                                day la noi dung 
                                day la noi dung 
                            </div>
                        </div>
                    </div>

                    <!-- receive -->
                    <div class="flex">
                        <div class="my__min--w rounded-full w-11 h-11 bg-white border border-gray-200 mx-1 md:mx-2 my-1">
                            <img src="../assets/images/zlogo.png" alt="" class="rounded-full w-full h-full">
                        </div>
                        <!-- list chat text -->
                        <div class="my__list--chat">
                            <div class="bg-white py-1 px-2 rounded my-1">
                                day la noi dung day la noi dung 
                                day la noi dung 
                                day la noi dung 
                                day la noi dung day la noi dung day la noi dung day la noi dung 
                                day la noi dung 
                                day la noi dung 
                                day la noi dung day la noi dung 
                                day la noi dung 

                                day la noi dung day la noi dung 

                                day la noi dung 
                                day la noi dung 
                                day la noi dung 
                                day la noi dung 
                                day la noi dung 
                                day la noi dung 
                                day la noi dung 
                                day la noi dung 
                                day la noi dung 
                            </div>
                            <div class="bg-white py-1 px-2 rounded my-1">
                                day la noi dung
                            </div>
                            <div class="bg-white py-1 px-2 rounded my-1">
                                day la noi dung
                            </div>
                        </div>
                    </div>

                    <!-- send -->
                    <div class="flex flex-row-reverse">
                        <div class="my__min--w rounded-full w-11 h-11 bg-white border border-gray-200 mx-1 md:mx-2 my-1">
                            <img src="../assets/images/zlogo.png" alt="" class="rounded-full w-full h-full">
                        </div>
                        <!-- list chat text -->
                        <div class="my__list--chat flex flex-col items-end">
                            <div class="bg-white py-1 px-2 rounded my-1">
                                day la noi dung
                            </div>
                            <div class="bg-white py-1 px-2 rounded my-1">
                                day la noi dung
                            </div>
                            <div class="bg-white py-1 px-2 rounded my-1">
                                day la noi dung
                                
                                day la noi dung day la noi dung 

                                day la noi dung 
                                day la noi dung 
                                day la noi dung 
                                day la noi dung 
                                day la noi dung 
                                day la noi dung 
                                day la noi dung 
                                day la noi dung 
                                day la noi dung 
                            </div>
                        </div>
                    </div>
                    <!-- receive -->
                    <div class="flex">
                        <div class="my__min--w rounded-full w-11 h-11 bg-white border border-gray-200 mx-1 md:mx-2 my-1">
                            <img src="../assets/images/zlogo.png" alt="" class="rounded-full w-full h-full">
                        </div>
                        <!-- list chat text -->
                        <div class="my__list--chat">
                            <div class="bg-white py-1 px-2 rounded my-1">
                                day la noi dung day la noi dung 
                                day la noi dung 
                                day la noi dung 
                                day la noi dung day la noi dung day la noi dung day la noi dung 
                                day la noi dung 
                                day la noi dung 
                                day la noi dung day la noi dung 
                                day la noi dung 

                                day la noi dung day la noi dung 

                                day la noi dung 
                                day la noi dung 
                                day la noi dung 
                                day la noi dung 
                                day la noi dung 
                                day la noi dung 
                                day la noi dung 
                                day la noi dung 
                                day la noi dung 
                            </div>
                            <div class="bg-white py-1 px-2 rounded my-1">
                                day la noi dung
                            </div>
                            <div class="bg-white py-1 px-2 rounded my-1">
                                day la noi dung
                            </div>
                        </div>
                    </div>

                    <!-- send -->
                    <div class="flex flex-row-reverse">
                        <div class="my__min--w rounded-full w-11 h-11 bg-white border border-gray-200 mx-1 md:mx-2 my-1">
                            <img src="../assets/images/zlogo.png" alt="" class="rounded-full w-full h-full">
                        </div>
                        <!-- list chat text -->
                        <div class="my__list--chat flex flex-col items-end">
                            <div class="bg-white py-1 px-2 rounded my-1">
                                day la noi dung
                            </div>
                            <div class="bg-white py-1 px-2 rounded my-1">
                                day la noi dung
                            </div>
                            <div class="bg-white py-1 px-2 rounded my-1">
                                day la noi dung
                                
                                day la noi dung day la noi dung 

                                day la noi dung 
                                day la noi dung 
                                day la noi dung 
                                day la noi dung 
                                day la noi dung 
                                day la noi dung 
                                day la noi dung 
                                day la noi dung 
                                day la noi dung 
                            </div>
                        </div>
                    </div>
                    <!-- receive -->
                    <div class="flex">
                        <div class="my__min--w rounded-full w-11 h-11 bg-white border border-gray-200 mx-1 md:mx-2 my-1">
                            <img src="../assets/images/zlogo.png" alt="" class="rounded-full w-full h-full">
                        </div>
                        <!-- list chat text -->
                        <div class="my__list--chat">
                            <div class="bg-white py-1 px-2 rounded my-1">
                                day la noi dung day la noi dung 
                                day la noi dung 
                                day la noi dung 
                                day la noi dung day la noi dung day la noi dung day la noi dung 
                                day la noi dung 
                                day la noi dung 
                                day la noi dung day la noi dung 
                                day la noi dung 

                                day la noi dung day la noi dung 

                                day la noi dung 
                                day la noi dung 
                                day la noi dung 
                                day la noi dung 
                                day la noi dung 
                                day la noi dung 
                                day la noi dung 
                                day la noi dung 
                                day la noi dung 
                            </div>
                            <div class="bg-white py-1 px-2 rounded my-1">
                                day la noi dung
                            </div>
                            <div class="bg-white py-1 px-2 rounded my-1">
                                day la noi dung
                            </div>
                        </div>
                    </div>

                    <!-- send -->
                    <div class="flex flex-row-reverse">
                        <div class="my__min--w rounded-full w-11 h-11 bg-white border border-gray-200 mx-1 md:mx-2 my-1">
                            <img src="../assets/images/zlogo.png" alt="" class="rounded-full w-full h-full">
                        </div>
                        <!-- list chat text -->
                        <div class="my__list--chat flex flex-col items-end">
                            <div class="bg-white py-1 px-2 rounded my-1">
                                day la noi dung
                            </div>
                            <div class="bg-white py-1 px-2 rounded my-1">
                                day la noi dung
                            </div>
                            <div class="bg-white py-1 px-2 rounded my-1">
                                day la noi dung
                                
                                day la noi dung day la noi dung 

                                day la noi dung 
                                day la noi dung 
                                day la noi dung 
                                day la noi dung 
                                day la noi dung 
                                day la noi dung 
                                day la noi dung 
                                day la noi dung 
                                day la noi dung 
                            </div>
                        </div>
                    </div>
                    <!-- receive -->
                    <div class="flex">
                        <div class="my__min--w rounded-full w-11 h-11 bg-white border border-gray-200 mx-1 md:mx-2 my-1">
                            <img src="../assets/images/zlogo.png" alt="" class="rounded-full w-full h-full">
                        </div>
                        <!-- list chat text -->
                        <div class="my__list--chat">
                            <div class="bg-white py-1 px-2 rounded my-1">
                                day la noi dung day la noi dung 
                                day la noi dung 
                                day la noi dung 
                                day la noi dung day la noi dung day la noi dung day la noi dung 
                                day la noi dung 
                                day la noi dung 
                                day la noi dung day la noi dung 
                                day la noi dung 

                                day la noi dung day la noi dung 

                                day la noi dung 
                                day la noi dung 
                                day la noi dung 
                                day la noi dung 
                                day la noi dung 
                                day la noi dung 
                                day la noi dung 
                                day la noi dung 
                                day la noi dung 
                            </div>
                            <div class="bg-white py-1 px-2 rounded my-1">
                                day la noi dung
                            </div>
                            <div class="bg-white py-1 px-2 rounded my-1">
                                day la noi dung
                            </div>
                        </div>
                    </div>

                    <!-- send -->
                    <div class="flex flex-row-reverse">
                        <div class="my__min--w rounded-full w-11 h-11 bg-white border border-gray-200 mx-1 md:mx-2 my-1">
                            <img src="../assets/images/zlogo.png" alt="" class="rounded-full w-full h-full">
                        </div>
                        <!-- list chat text -->
                        <div class="my__list--chat flex flex-col items-end">
                            <div class="bg-white py-1 px-2 rounded my-1">
                                day la noi dung
                            </div>
                            <div class="bg-white py-1 px-2 rounded my-1">
                                day la noi dung
                            </div>
                            <div class="bg-white py-1 px-2 rounded my-1">
                                day la noi dung
                                
                                day la noi dung day la noi dung 

                                day la noi dung 
                                day la noi dung 
                                day la noi dung 
                                day la noi dung 
                                day la noi dung 
                                day la noi dung 
                                day la noi dung 
                                day la noi dung 
                                day la noi dung 
                            </div>
                        </div>
                    </div>
                    <!-- receive -->
                    <div class="flex">
                        <div class="my__min--w rounded-full w-11 h-11 bg-white border border-gray-200 mx-1 md:mx-2 my-1">
                            <img src="../assets/images/zlogo.png" alt="" class="rounded-full w-full h-full">
                        </div>
                        <!-- list chat text -->
                        <div class="my__list--chat">
                            <div class="bg-white py-1 px-2 rounded my-1">
                                day la noi dung day la noi dung 
                                day la noi dung 
                                day la noi dung 
                                day la noi dung day la noi dung day la noi dung day la noi dung 
                                day la noi dung 
                                day la noi dung 
                                day la noi dung day la noi dung 
                                day la noi dung 

                                day la noi dung day la noi dung 

                                day la noi dung 
                                day la noi dung 
                                day la noi dung 
                                day la noi dung 
                                day la noi dung 
                                day la noi dung 
                                day la noi dung 
                                day la noi dung 
                                day la noi dung 
                            </div>
                            <div class="bg-white py-1 px-2 rounded my-1">
                                day la noi dung
                            </div>
                            <div class="bg-white py-1 px-2 rounded my-1">
                                day la noi dung
                            </div>
                        </div>
                    </div>

                    <!-- send -->
                    <div class="flex flex-row-reverse">
                        <div class="my__min--w rounded-full w-11 h-11 bg-white border border-gray-200 mx-1 md:mx-2 my-1">
                            <img src="../assets/images/zlogo.png" alt="" class="rounded-full w-full h-full">
                        </div>
                        <!-- list chat text -->
                        <div class="my__list--chat flex flex-col items-end">
                            <div class="bg-white py-1 px-2 rounded my-1">
                                day la noi dung
                            </div>
                            <div class="bg-white py-1 px-2 rounded my-1">
                                day la noi dung
                            </div>
                            <div class="bg-white py-1 px-2 rounded my-1">
                                day la noi dung
                                
                                day la noi dung day la noi dung 

                                day la noi dung 
                                day la noi dung 
                                day la noi dung 
                                day la noi dung 
                                day la noi dung 
                                day la noi dung 
                                day la noi dung 
                                day la noi dung 
                                day la noi dung 
                            </div>
                        </div>
                    </div>
                    

                </div>

                <!-- input send -->
                <div class="fixed bottom-0 bg-white w-full my__frame--chat">
                    <!-- option send -->
                    <div class="flex items-center justify-start p-2 border border-gray-200">
                        <i class='bx bxs-file text-2xl mx-2 text-purple-500 cursor-pointer'></i>
                        <i class='bx bx-image-alt text-2xl mx-2 text-green-500 cursor-pointer' ></i>
                        <i class='bx bxs-wink-smile ml-1 text-2xl text-yellow-500 cursor-pointer border border-gray-300 rounded-full' ></i>

                    </div>
                    <!-- input -->
                    <div class="flex items-center justify-between p-3">
                        <div contenteditable="true" class=" outline-none  overflow-y-scroll" id="txtMessage"></div>
                        
                        <!-- <div class="flex justify-between"> -->
                            <i class='bx bxs-send text-blue-700 text-2xl cursor-pointer' ></i>
                        <!-- </div> -->
                        
                    </div>
                </div>
            </div>
        </div>
</template>

<script>
import ConversationComponent from '@/components/ConversationComponent.vue'

export default {
  name: 'Home',
  components: {
    ConversationComponent
  },
  data() {
    return {
      conversations: []
    }
  },
  mounted() {
    this.conversations = [
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
   
  /* Handle */
  ::-webkit-scrollbar-thumb {
    background: #888;
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
    height: calc(100vh - 56px);
  }

  @media (min-width: 768px) {
    #list__message {
        height: calc(100vh - 156px);
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

.my__list--chat div {
    max-width: 70%;
    width: fit-content;
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
  display: none;
}

#txtSearch:focus + .my__close {
  display: block;
}
</style>