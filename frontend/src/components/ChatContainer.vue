<template>
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

            <div class="flex" :class="[chat.sender == 'me' ? 'flex-row-reverse' : '']" v-for="chat in chats" :key="chat.sender">
                <send-message v-if="chat.sender == 'me'" :chat='chat' />
                <receive-message v-else :chat='chat' />
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
</template>

<script>
import ReceiveMessage from './ReceiveMessage.vue'
import SendMessage from './SendMessage.vue'
export default {
    name: 'ChatContainer',
    components: {
        ReceiveMessage,
        SendMessage
    },
    data() {
        return {
            chats: []
        }
    },
    mounted() {
        this.chats = [
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
                }
                
        ]
    }
}
</script>

<style>

</style>