<template>
    <div class="row mt-4">
        <div class="col-md-12">
            <h1>Voluntarios cercanos</h1>
            <table class="table table-striped">
                <thead class="thead-dark">
                    <tr>
                        <th>Nombre</th>
                        <th>Ubicación</th>
                        <th>Acciones</th>
                    </tr>
                </thead>
                <tbody>
                    <tr v-for="user in usuarios" :key="user.nombre">
                        <td>{{ user.nombre }}</td>
                        <td> {{ user.latitud }} , {{ user.longitud }}</td>
                        <td>
                            <router-link :to="{name: 'edit', params: { id: user._id }}" class="btn btn-success">Invitar
                            </router-link>
                            <button @click.prevent="deleteUser(user._id)" class="btn btn-danger ">Rechazar</button>
                        </td>
                    </tr>
                </tbody>
            </table>
        </div>
    </div>
</template>

<script>
    export default {
        data() {
            return {
                Users: []
            }
        },
        props: [
            'usuarios'
        ],
        created() {
        },
        methods: {
        }
    }
</script>

<style>
    .btn-success {
        margin-right: 10px;
    }
</style>