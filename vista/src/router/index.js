import Vue from 'vue'
import VueRouter from 'vue-router'

Vue.use(VueRouter)


const routes = [
  //Primera pagina
  {
    path: '/',
    name: 'home',
    component: () => import('../components/general/Home')
  },
  //Pagin about
  {
    path: '/about',
    name: 'about',
    component: () => import('../components/general/About')
  },

  //-----------------------------------------------------------------------------------------------------------
  //Paginas de usuario
  {
    path: '/registrar',
    name: 'registrar',
    component: () => import('../components/usuario/Registrar.vue')
  },
  {
    path: '/login',
    name: 'login',
    component: () => import('../components/usuario/Login.vue')
  },

  //Tareas 
  {
    path: '/tareas',
    name: 'tareas',
    component: () => import('../components/tareas/Tareas')
  },
  {
    path: '/tarea/:id',
    name: 'tarea',
    component: () => import('../components/tareas/Tarea')
  },
  //
  /*
  {
    path: '/preguntas_frecuentes',
    name: 'preguntas frecuentes',
    component: () => import('../components/general/PreguntasFrecuentes.vue')
  },

  {
    path: '/view',
    name: 'view',
    component: () => import('../components/usuario/ListaUsuarios')
  },
  {
    path: '/edit/:id',
    name: 'edit',
    component: () => import('../components/usuario/EditarUsuario')
  },
  {
    path: '/home',
    name: 'logeado',
    component: () => import('../components/usuario/Landing')
  },  
  {
    path: '/proyecto/:id',
    name: 'proyecto',
    component: () => import('../components/proyectos/Proyecto')
  },
  {
    path: '/my-proyect/:id',
    name: 'MiProyecto',
    component: () => import('../components/proyectos/MiProyecto')
  },
  {
    path: '/my-proyects',
    name: 'MisProyecto',
    component: () => import('../components/proyectos/MisProyectos')
  },
  {
    path: '/editProyect/:id',
    name: 'editProyect',
    component: () => import('../components/proyectos/EditarProyecto')
  },
  {
    path: '/post',
    name: 'postear',
    component: () => import('../components/proyectos/RegistrarProyecto')
  }
  */
  
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router