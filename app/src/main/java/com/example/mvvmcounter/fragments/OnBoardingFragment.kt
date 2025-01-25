import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.mvvmcounter.MainActivity
import com.example.mvvmcounter.OnboardingViewModel
import com.example.mvvmcounter.databinding.FragmentOnBoardingBinding
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class OnboardingFragment : Fragment() {

    private lateinit var binding: FragmentOnBoardingBinding
    private val viewModel: OnboardingViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentOnBoardingBinding.inflate(inflater, container, false)

        val adapter = OnboardingAdapter(viewModel.pages)
        binding.viewPager.adapter = adapter

        TabLayoutMediator(binding.tabLayout, binding.viewPager) { _, _ -> }.attach()

        binding.buttonSkip.setOnClickListener {
            viewModel.completeOnboarding()
            navigateToMainScreen()
        }

        binding.buttonNext.setOnClickListener {
            if (binding.viewPager.currentItem < viewModel.pages.size - 1) {
                binding.viewPager.currentItem++
            } else {
                viewModel.completeOnboarding()
                navigateToMainScreen()
            }
        }

        return binding.root
    }

    private fun navigateToMainScreen() {
        startActivity(Intent(requireContext(), MainActivity::class.java))
        requireActivity().finish()
    }
}

